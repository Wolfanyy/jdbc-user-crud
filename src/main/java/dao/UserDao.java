package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    boolean update(User user);

    boolean deleteById(Long id);
}