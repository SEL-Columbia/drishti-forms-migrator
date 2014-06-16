package app.scheduler;

import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;

@Every("1s")
public class JobScheduler extends Job {
    @Override
    public void doJob() {
        System.out.println("************");
        System.out.println("Hello");
    }
}
