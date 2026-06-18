package util;

import dao.UserDaoImpl;
import service.UserService;
import service.UserServiceImpl;
import validation.UserValidator;

public class AppContext {

    private static final UserService USER_SERVICE =
            new UserServiceImpl(
                    new UserDaoImpl(),
                    new UserValidator()
            );

    private AppContext() {
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}