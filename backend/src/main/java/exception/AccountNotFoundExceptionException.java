package exception;

public class AccountNotFoundExceptionException extends EntidadeNaoEncontradaException {
    public AccountNotFoundExceptionException(String message) {
        super(message);
    }
}
