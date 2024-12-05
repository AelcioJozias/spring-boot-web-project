package exception;

public class CpfInUseExceptionException extends EntityInUserException {
  public CpfInUseExceptionException(String message) {
    super(message);
  }
}
