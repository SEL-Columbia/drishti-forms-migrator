package app.repository;

import app.exception.FormMigrationException;
import app.model.Audit;
import app.model.BaseEntity;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

public class Repository extends AbstractDAO<BaseEntity> {
    private SessionFactory sessionFactory;

    public Repository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public BaseEntity create(BaseEntity entityForm) {
        try {
            return persist(entityForm);
        } catch (Exception ex) {
            throw new FormMigrationException("Could not save the " + entityForm.getClass().toString(), ex);
        }
    }

    public Audit getLastAudit() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Audit.class).setProjection(Projections.max("lastPolledTimestamp"));

        Session session = sessionFactory.getCurrentSession();
        try {
            return (Audit) session.createCriteria(Audit.class)
                    .add(Property.forName("lastPolledTimestamp").eq(detachedCriteria))
                    .uniqueResult();
        } catch (Exception ex) {
            throw new FormMigrationException("Could not fetch last audit", ex);
        }
    }
}
