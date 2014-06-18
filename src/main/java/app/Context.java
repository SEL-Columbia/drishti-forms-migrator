package app;

import app.repository.PersonRepository;
import org.hibernate.SessionFactory;

public class Context {
    private static Context context;
    private PersonRepository repository;
    private SessionFactory sessionFactory;

    protected Context() {}

    public static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public PersonRepository repository() throws ClassNotFoundException {

        if (repository == null) {
            repository = new PersonRepository(sessionFactory);
        }
        return repository;
    }

    public void updateSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
