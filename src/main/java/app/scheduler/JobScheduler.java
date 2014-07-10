package app.scheduler;

import app.Context;
import app.MigratorConfiguration;
import app.model.Audit;
import app.repository.Repository;
import app.service.FormService;
import app.util.HttpClient;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static app.Constants.TIMESTAMP;
import static java.lang.Long.valueOf;

@Every("default")
public class JobScheduler extends Job {
    private final Repository repository;
    private final FormService formService;
    private final MigratorConfiguration configuration;
    private final Logger logger = LoggerFactory.getLogger(JobScheduler.class);
    private HttpClient httpClient;

    public JobScheduler() {
        Context context = Context.getInstance();
        repository = context.repository();
        formService = context.formService();
        configuration = context.configuration();
        httpClient = new HttpClient();
    }

    public JobScheduler(Repository repository, FormService formService, MigratorConfiguration configuration, HttpClient httpClient) {
        this.repository = repository;
        this.formService = formService;
        this.configuration = configuration;
        this.httpClient = httpClient;
    }

    @Override
    public void doJob() {
        logger.info("************");
        logger.info("Scheduled job started");

        process();

        logger.info("Scheduled job ended");
        logger.info("************");
    }

    private void process() {
        URI pollingUri = getBaseURI(configuration.getPollingUrl(), repository.getLastAudit());

        logger.info("Fetching form entries from: " + pollingUri.toString());

        List<Map<String, Object>> responseData = httpClient.call(pollingUri, configuration.getPollingUrlUsername(), configuration.getPollingUrlPassword());

        logger.info("Processing " + responseData.size() + " form entries");

        List<Map<String, Object>> processedForms = formService.save(responseData);
        createAuditFor(processedForms, responseData.size());
    }

    private static URI getBaseURI(String uri, Audit lastPolledAuditEntry) {
        lastPolledAuditEntry = lastPolledAuditEntry == null ? Audit.DEFAULT : lastPolledAuditEntry;
        return UriBuilder.fromUri(uri).replaceQueryParam(TIMESTAMP, lastPolledAuditEntry.getLastPolledTimestamp()).build();
    }

    private void createAuditFor(List<Map<String, Object>> processedForms, long actualFormCount) {
        if(actualFormCount == 0)
            return;

        Map<String, Object> maxVersionedForm = processedForms.stream().max((form1, form2) ->
                getParsedVersion(form1) >= getParsedVersion(form2) ? 1 : -1
        ).get();

        repository.create(new Audit(getParsedVersion(maxVersionedForm), actualFormCount));
    }

    private Long getParsedVersion(Map<String, Object> form1) {
        return valueOf((String) form1.get(SERVER_VERSION));
    }
}
