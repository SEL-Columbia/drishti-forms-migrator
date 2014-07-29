package app.repository;

@FunctionalInterface
public interface JTransaction {
    public Object doInTransaction();
}
