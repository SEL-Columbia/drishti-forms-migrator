package app.repository;

import app.model.Person;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;

public class PersonRepository extends AbstractDAO<Person>{
    private SessionFactory sessionFactory;

    public PersonRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public void create(Person person) {
        Session session = sessionFactory.openSession();
        try {
            ManagedSessionContext.bind(session);
            persist(person);
        } catch (Exception ex) {
            System.out.println("!!!!!!!! Error !!!!!!!!");
        }
        finally {
            session.flush();
        }

    }
}
