package app;

import app.repository.JTransaction;
import app.repository.TransactionManager;

public class MockTransactionManager extends TransactionManager {
    public MockTransactionManager() {
        super(null);
    }

    @Override
    public Object doInTransaction(JTransaction transaction) {
        return transaction.doInTransaction();
    }
}
