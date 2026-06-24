package service;

import dao.UserDao;
import exception.DuplicateEmailException;
import exception.UserNotFoundException;
import model.User;
import validation.UserValidator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserValidator userValidator;

    public UserServiceImpl(UserDao userDao,
                           UserValidator userValidator) {
        this.userDao = userDao;
        this.userValidator = userValidator;
    }

    @Override
    public User save(User user) {

        userValidator.validate(user);

        validateUniqueEmail(user);

        return userDao.save(user);
    }

    @Override
    public User findById(Long id) {

        userValidator.validateId(id);

        return getUserOrThrow(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User update(User user) {

        userValidator.validate(user);
        userValidator.validateId(user.getId());

        getUserOrThrow(user.getId());

        validateUniqueEmail(user);

        userDao.update(user);

        return user;
    }

    @Override
    public void deleteById(Long id) {

        userValidator.validateId(id);

        getUserOrThrow(id);

        userDao.deleteById(id);
    }

    private void validateUniqueEmail(User user) {

        userDao.findByEmail(user.getEmail())
                .ifPresent(existingUser -> {

                    boolean anotherUserWithSameEmail =
                            user.getId() == null
                                    || !existingUser.getId()
                                    .equals(user.getId());

                    if (anotherUserWithSameEmail) {
                        throw new DuplicateEmailException(
                                user.getEmail()
                        );
                    }
                });
    }

    private User getUserOrThrow(Long id) {

        return userDao.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(id));
    }
}
