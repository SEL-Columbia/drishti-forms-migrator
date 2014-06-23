package app;

import app.model.*;
import app.repository.Repository;
import app.scheduler.JobScheduler;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.yammer.dropwizard.migrations.MigrationsBundle;
import de.spinscale.dropwizard.jobs.JobsBundle;


public class ApplicationService extends Service<MigratorConfiguration> {

    private final String contentMigrator = "ContentMigrator";

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    private final HibernateBundle<MigratorConfiguration> hibernateBundle =
            new HibernateBundle<MigratorConfiguration>(AncClose.class, AncRegistration.class, AncRegistrationOa.class, AncVisit.class,
                    ChildClose.class, ChildIllness.class, ChildImmunizations.class, ChildRegistrationEc.class, ChildRegistrationOa.class,
                    DeliveryOutcome.class, DeliveryPlan.class,
                    EcClose.class, EcEdit.class, EcRegistration.class,
                    FpChange.class, FpComplications.class, FpFollowup.class,
                    HbTest.class, Ifa.class,
                    PncClose.class, PncRegistrationOa.class, PncVisit.class, PostpartumFamilyPlanning.class,
                    RecordEcps.class, RenewFpProduct.class, Tt.class, VitaminA.class) {
                @Override
                public DatabaseConfiguration getDatabaseConfiguration(MigratorConfiguration configuration) {
                    return configuration.getDatabase();
                }
            };


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
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(MigratorConfiguration configuration, Environment environment) throws Exception {
        Repository repository = new Repository(hibernateBundle.getSessionFactory());

        Context context = Context.getInstance();
        context.updateSessionFactory(hibernateBundle.getSessionFactory())
            .updateConfiguration(configuration);

//        final DBIFactory factory = new DBIFactory();
//        final DBI jdbi = factory.build(environment, configuration.getDatabase(), contentMigrator);

        new JobScheduler().doJob();
    }
}
