package app;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;


public class ApplicationService extends Service<MigratorConfiguration> {
    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MigratorConfiguration> bootstrap) {
        bootstrap.setName("Micro");
    }

    @Override
    public void run(MigratorConfiguration configuration, Environment environment) throws Exception {
    }
}
