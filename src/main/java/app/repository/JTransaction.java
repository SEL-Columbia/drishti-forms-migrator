package app.repository;

import app.model.BaseEntity;

@FunctionalInterface
public interface JTransaction {
    public Object doInTransaction();
}
