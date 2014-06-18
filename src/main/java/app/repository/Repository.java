package app.repository;

import app.model.EntityForm;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;

public class Repository extends AbstractDAO<EntityForm>{
    private SessionFactory sessionFactory;

    public Repository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public void create(EntityForm entityForm) {
        Session session = sessionFactory.openSession();
        try {
            ManagedSessionContext.bind(session);
            persist(entityForm);
        } catch (Exception ex) {
            System.out.println("!!!!!!!! Error !!!!!!!!");
            System.out.println(ex.getMessage());
        }
    }
}
