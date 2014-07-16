package app;

import app.repository.Repository;
import app.repository.TransactionManager;
import app.scheduler.FormMigratorJob;
import app.scheduler.Job;
import app.service.AuditService;
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
    private TransactionManager transactionManager;
    private AuditService auditService;

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
            formMigratorJob = new FormMigratorJob(formService(), auditService(), configuration, new HttpClient());
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

    public TransactionManager transactionManager() {
        if(transactionManager == null) {
            transactionManager = new TransactionManager(sessionFactory);
        }
        return transactionManager;
    }

    public MigratorConfiguration configuration() {
        return configuration;
    }

    public FormService formService() {
        if(formService == null) {
            formService = new FormService(repository(), new MapTransformer(), new ObjectConverter(), transactionManager());
        }
        return formService;
    }

    public AuditService auditService() {
        if(auditService == null) {
            auditService = new AuditService(repository(), transactionManager());
        }
        return auditService;
    }
}
