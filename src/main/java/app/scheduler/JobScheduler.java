package app.scheduler;

import app.Context;
import app.MigratorConfiguration;
import app.model.BaseEntityForm;
import app.repository.Repository;
import app.util.HttpClient;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;

import java.util.List;
import java.util.Map;

import static app.Constants.SUB_FORMS;

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
            BaseEntityForm savedEntity = persist(ObjectConverter.create(map));

            if(savedEntity != null && map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
                List<Map<String, Object>> subForms = (List<Map<String, Object>>) map.get(SUB_FORMS);
                for (Map<String, Object> subForm : subForms) {
                    subForm.put("parentId", savedEntity.getId());
                    persist(ObjectConverter.create(subForm));
                }
            }
        }

    }

    private BaseEntityForm persist(BaseEntityForm entity) {
        if(entity == null)
            return null;
        try {
            Repository repository = context.repository();
            return repository.create(entity);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}
