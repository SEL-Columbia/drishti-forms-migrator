package app.scheduler;

import app.Context;
import app.MigratorConfiguration;
import app.util.HttpClient;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static app.Constants.TIMESTAMP;

@Every("30min")
public class JobScheduler extends Job {
    private final Context context;
    private final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    public JobScheduler() {
        context = Context.getInstance();
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
        MigratorConfiguration configuration = context.configuration();
        URI pollingUri = getBaseURI(configuration.getPollingUrl());

        logger.info("Fetching form entries from: " + pollingUri.toString());

        List<Map<String, Object>> responseData = HttpClient.call(pollingUri, configuration.getPollingUrlUsername(), configuration.getPollingUrlPassword());

        logger.info("Processing " + responseData.size() + " form entries");

        context.formService().save(responseData);
    }

    private static URI getBaseURI(String uri) {
        return UriBuilder.fromUri(uri).replaceQueryParam(TIMESTAMP, new Date().getTime()).build();
    }
}
