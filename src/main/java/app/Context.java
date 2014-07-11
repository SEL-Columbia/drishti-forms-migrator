package app;

import app.repository.Repository;
import app.scheduler.FormMigratorJob;
import app.scheduler.Job;
import app.service.FormService;
import app.util.HttpClient;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import org.hibernate.SessionFactory;

public class Context {
    private static Context context;
    private Repository repository;
    private FormService formService;
    private SessionFactory sessionFactory;
    private FormMigratorJob formMigratorJob;
    private MigratorConfiguration configuration;

    protected Context() {}

    public static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public Repository repository() {
        if (repository == null) {
            repository = new Repository(sessionFactory);
        }
        return repository;
    }

    public Job job() {
        if (formMigratorJob == null) {
            formMigratorJob = new FormMigratorJob(repository(), formService(), configuration, new HttpClient());
        }
        return formMigratorJob;
    }

    public Context updateSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        return this;
    }

    public Context updateConfiguration(MigratorConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public MigratorConfiguration configuration() {
        return configuration;
    }

    public FormService formService() {
        if(formService == null) {
            formService = new FormService(repository(), new MapTransformer(), new ObjectConverter());
        }
        return formService;
    }
}
