package app;

import app.scheduler.JobScheduler;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import de.spinscale.dropwizard.jobs.JobsBundle;


public class ApplicationService extends Service<MigratorConfiguration> {
    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MigratorConfiguration> bootstrap) {
        bootstrap.setName("ContentMigrator");
        bootstrap.addBundle(new JobsBundle("app"));
    }

    @Override
    public void run(MigratorConfiguration configuration, Environment environment) throws Exception {
        new JobScheduler().doJob();
    }
}
