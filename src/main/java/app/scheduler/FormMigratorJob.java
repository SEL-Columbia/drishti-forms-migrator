package app.scheduler;

import app.MigratorConfiguration;
import app.model.Audit;
import app.repository.Repository;
import app.service.AuditService;
import app.service.FormService;
import app.util.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.AudioSystem;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static app.Constants.TIMESTAMP;
import static java.lang.Long.valueOf;

public class FormMigratorJob implements Job {
    private final AuditService auditService;
    private final FormService formService;
    private final MigratorConfiguration configuration;
    private final Logger logger = LoggerFactory.getLogger(FormMigratorJob.class);
    private HttpClient httpClient;

    public FormMigratorJob(FormService formService, AuditService auditService, MigratorConfiguration configuration, HttpClient httpClient) {
        this.formService = formService;
        this.configuration = configuration;
        this.httpClient = httpClient;
        this.auditService = auditService;
    }

    public void process() {
        URI pollingUri = getBaseURI();
        logger.info("Fetching form entries from: " + pollingUri.toString());

        List<Map<String, Object>> responseData = httpClient.call(pollingUri, configuration.getPollingUrlUsername(), configuration.getPollingUrlPassword());

        logger.info("Processing " + responseData.size() + " form entries");
        List<Map<String, Object>> processedForms = formService.save(responseData);
        logger.info("Successfully processed " + processedForms.size() + " of " + responseData.size() + " form entries");

        auditService.createAuditFor(processedForms, responseData);
    }

    private URI getBaseURI() {
        Audit lastPolledAuditEntry = auditService.getLastAudit();
        lastPolledAuditEntry = lastPolledAuditEntry == null ? Audit.DEFAULT : lastPolledAuditEntry;

        return UriBuilder.fromUri(configuration.getPollingUrl())
                .replaceQueryParam(TIMESTAMP, lastPolledAuditEntry.getLastPolledTimestamp())
                .build();
    }
}
