package app.scheduler;

import app.Context;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Every("default")
public class JobScheduler extends Job {
    private final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    @Override
    public void doJob() {
        logger.info("************");
        logger.info("Scheduled job started");

        Context.getInstance().job().process();

        logger.info("Scheduled job ended");
        logger.info("************");
    }
}
