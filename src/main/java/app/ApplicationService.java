package app;

import app.scheduler.JobScheduler;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.migrations.MigrationsBundle;
import de.spinscale.dropwizard.jobs.JobsBundle;
import org.skife.jdbi.v2.DBI;


public class ApplicationService extends Service<MigratorConfiguration> {

    private final String contentMigrator = "ContentMigrator";

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MigratorConfiguration> bootstrap) {
        bootstrap.setName(contentMigrator);

        bootstrap.addBundle(new JobsBundle("app"));
        bootstrap.addBundle(new MigrationsBundle<MigratorConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(MigratorConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
    }

    @Override
    public void run(MigratorConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), contentMigrator);

        new JobScheduler().doJob();
    }
}
