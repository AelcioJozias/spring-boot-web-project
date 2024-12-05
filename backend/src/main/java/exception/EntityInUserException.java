package exception;

public class EntityInUserException extends RuntimeException {
    public EntityInUserException(String message) {
        super(message);
    }
}
