package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    User findById(Long id);

    List<User> findAll();

    User update(User user);

    void deleteById(Long id);
}
