package exception;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
