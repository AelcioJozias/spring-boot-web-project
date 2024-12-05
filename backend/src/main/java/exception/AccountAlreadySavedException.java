package exception;

public class AccountAlreadySavedException extends EntityInUserException {
    public AccountAlreadySavedException(String message) {
        super(message);
    }
}
