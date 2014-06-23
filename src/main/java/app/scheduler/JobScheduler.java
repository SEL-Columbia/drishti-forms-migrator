package app.scheduler;

import app.Context;
import app.MigratorConfiguration;
import app.model.EntityForm;
import app.repository.Repository;
import app.util.HttpClient;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;

import java.util.List;
import java.util.Map;

@Every("30min")
public class JobScheduler extends Job {
    private final Context context;

    public JobScheduler() {
        context = Context.getInstance();
    }

    @Override
    public void doJob() {
        System.out.println("************");
        System.out.println("Started the job");

        process();

        System.out.println("Job Ended");
        System.out.println("************");
    }

    private void process() {
        MigratorConfiguration configuration = context.configuration();
        List<Map<String, Object>> responseData = HttpClient.call(configuration.getPollingUrl(), configuration.getPollingUrlUsername(), configuration.getPollingUrlPassword());
        List<Map<String, Object>> mappedData = new MapTransformer().transform(responseData);
        for (Map<String, Object> map : mappedData) {
            persist(ObjectConverter.create(map));
        }

    }

    private void persist(EntityForm entity) {
        try {
            Repository repository = context.repository();
            repository.create(entity);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
