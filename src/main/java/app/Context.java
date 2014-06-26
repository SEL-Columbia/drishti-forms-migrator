package app;

import app.repository.Repository;
import app.service.FormService;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import org.hibernate.SessionFactory;

public class Context {
    private static Context context;
    private Repository repository;
    private FormService formService;
    private SessionFactory sessionFactory;
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
