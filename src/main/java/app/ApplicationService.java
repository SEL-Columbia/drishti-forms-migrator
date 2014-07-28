package app;

import app.model.Audit;
import app.model.ErrorAudit;
import app.model.forms.*;
import app.model.subForms.ChildPncVisit;
import app.model.subForms.ChildRegistration;
import app.model.subForms.PncChildRegistration;
import app.resource.FormResource;
import de.spinscale.dropwizard.jobs.ConfiguredJobsBundle;
import de.spinscale.dropwizard.jobs.config.JobConfiguration;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class ApplicationService extends Application<MigratorConfiguration> {

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
                    RecordEcps.class, RenewFpProduct.class, Tt.class, VitaminA.class,
                    PncChildRegistration.class, ChildRegistration.class, ChildPncVisit.class,
                    FpReferralFollowup.class, AncInvestigations.class,
                    Audit.class, ErrorAudit.class) {

                @Override
                public DataSourceFactory getDataSourceFactory(MigratorConfiguration configuration) {
                    return configuration.getDatabase();
                }
            };


    @Override
    public String getName() {
        return contentMigrator;
    }

    @Override
    public void initialize(Bootstrap<MigratorConfiguration> bootstrap) {
        bootstrap.addBundle(new ConfiguredJobsBundle<MigratorConfiguration>() {
            @Override
            public JobConfiguration getJobConfiguration(MigratorConfiguration migratorConfiguration) {
                return migratorConfiguration.getJobs();
            }
        });
        bootstrap.addBundle(new MigrationsBundle<MigratorConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(MigratorConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(MigratorConfiguration configuration, Environment environment) throws Exception {
        Context context = Context.getInstance();
        context.updateSessionFactory(hibernateBundle.getSessionFactory())
                .updateConfiguration(configuration);

        environment.jersey().register(new FormResource(context.formService()));
    }
}
