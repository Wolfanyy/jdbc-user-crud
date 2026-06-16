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

        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEmailException(user.getEmail());
        }

        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {

        userValidator.validateId(id);

        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean update(User user) {

        userValidator.validate(user);
        userValidator.validateId(user.getId());

        getUserOrThrow(user.getId());

        validateUniqueEmail(user);

        return userDao.update(user);
    }

    @Override
    public boolean deleteById(Long id) {

        userValidator.validateId(id);

        getUserOrThrow(id);

        return userDao.deleteById(id);
    }

    private void validateUniqueEmail(User user) {

        Optional<User> userWithSameEmail =
                userDao.findByEmail(user.getEmail());

        if (userWithSameEmail.isPresent()
                && !userWithSameEmail.get()
                .getId()
                .equals(user.getId())) {

            throw new DuplicateEmailException(user.getEmail());
        }
    }

    private User getUserOrThrow(Long id) {
        return userDao.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(id));
    }
}
