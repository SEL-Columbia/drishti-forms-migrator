package app.scheduler;

import app.Context;
import app.MigratorConfiguration;
import app.util.HttpClient;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

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

        List<Map<String, Object>> responseData = HttpClient.call(configuration.getPollingUrl(),
                configuration.getPollingUrlUsername(),
                configuration.getPollingUrlPassword());

        context.formService().save(responseData);
    }
}
