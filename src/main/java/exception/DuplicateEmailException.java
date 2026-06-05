package exception;

public class DuplicateEmailException extends ServiceException {

    public DuplicateEmailException(String email) {
        super("User with email '" + email + "' already exists");
    }
}
