package app.repository;

import app.model.BaseEntity;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repository extends AbstractDAO<BaseEntity> {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(Repository.class);

    public Repository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public BaseEntity create(BaseEntity entityForm) {
        if(entityForm == null)
            return null;
        Session session = sessionFactory.openSession();
        try {
            ManagedSessionContext.bind(session);
            return persist(entityForm);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            session.close();
        }
        return null;
    }
}
