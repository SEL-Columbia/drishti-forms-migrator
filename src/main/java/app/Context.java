package app;

import app.repository.Repository;
import org.hibernate.SessionFactory;

public class Context {
    private static Context context;
    private Repository repository;
    private SessionFactory sessionFactory;

    protected Context() {}

    public static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public Repository repository() throws ClassNotFoundException {

        if (repository == null) {
            repository = new Repository(sessionFactory);
        }
        return repository;
    }

    public void updateSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
