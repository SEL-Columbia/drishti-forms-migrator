package app.repository;

import app.model.Audit;
import app.model.BaseEntity;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class Repository extends AbstractDAO<BaseEntity> {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(Repository.class);

    public Repository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public BaseEntity create(BaseEntity entityForm) {
        if (entityForm == null)
            return null;
        BiFunction<BaseEntity, Session, BaseEntity> func = (query, session) -> persist(query);
        return exec(func, entityForm);
    }

    public Audit getLastAudit() {
        BiFunction<BaseEntity, Session, BaseEntity> func = (entity, session) -> (Audit) session.createCriteria(Audit.class)
                .add(Property.forName("lastPolledTimestamp").eq(DetachedCriteria
                        .forClass(Audit.class)
                        .setProjection(Projections.max("lastPolledTimestamp"))))
                .uniqueResult();

        return (Audit) exec(func, null);
    }

    private BaseEntity exec(BiFunction<BaseEntity, Session, BaseEntity> func, BaseEntity entityForm) {
        Session session = sessionFactory.openSession();
        try {
            ManagedSessionContext.bind(session);
            return func.apply(entityForm, session);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            session.close();
        }
        return null;
    }
}
