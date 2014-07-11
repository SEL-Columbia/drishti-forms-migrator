package app.scheduler;

import app.MigratorConfiguration;
import app.model.Audit;
import app.repository.Repository;
import app.service.FormService;
import app.util.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static app.Constants.TIMESTAMP;
import static java.lang.Long.valueOf;

public class FormMigratorJob implements Job {
    private final Repository repository;
    private final FormService formService;
    private final MigratorConfiguration configuration;
    private final Logger logger = LoggerFactory.getLogger(FormMigratorJob.class);
    private HttpClient httpClient;

    public FormMigratorJob(Repository repository, FormService formService, MigratorConfiguration configuration, HttpClient httpClient) {
        this.repository = repository;
        this.formService = formService;
        this.configuration = configuration;
        this.httpClient = httpClient;
    }

    public void process() {
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
