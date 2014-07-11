package app.exception;

public class FormMigrationException extends RuntimeException {

    public FormMigrationException(String message, Throwable ex) {
        super(message, ex);
    }

    public FormMigrationException(String message) {
        super(message);
    }
}
