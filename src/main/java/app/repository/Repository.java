package app.repository;

import app.model.BaseEntityForm;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;

public class Repository extends AbstractDAO<BaseEntityForm> {
    private SessionFactory sessionFactory;

    public Repository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public BaseEntityForm create(BaseEntityForm entityForm) {
        Session session = sessionFactory.openSession();
        try {
            ManagedSessionContext.bind(session);
            return persist(entityForm);
        } catch (Exception ex) {
            System.out.println("!!!!!!!! Error !!!!!!!!");
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return null;
    }
}
