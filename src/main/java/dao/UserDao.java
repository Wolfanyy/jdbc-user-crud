package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);

    void update(User user);

    void deleteById(Integer id);

    Optional<User> findById(Integer id);

    List<User> findAll();
}
