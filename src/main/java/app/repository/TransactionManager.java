package app.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;

public class TransactionManager {
    private SessionFactory sessionFactory;

    public TransactionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object doInTransaction(JTransaction transaction) {
        try {
            initTransaction();
            Object response = transaction.doInTransaction();
            commit();
            return response;
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }

    private void initTransaction() {
        Session session = sessionFactory.openSession();
        ManagedSessionContext.bind(session);
        session.beginTransaction();
    }

    private void rollback() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().rollback();
        session.close();
    }

    private void commit() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().commit();
        session.close();
    }
}