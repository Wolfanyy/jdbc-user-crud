package dao;

import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final String SAVE_USER = """
            INSERT INTO users(name, last_name, email, age)
            VALUES (?, ?, ?, ?)
            RETURNING id
            """;

    private static final String FIND_BY_ID = """
            SELECT * 
            FROM users 
            WHERE id = ? 
            """;

    private static final String FIND_BY_EMAIL = """
            SELECT *
            FROM users
            WHERE email = ?
            """;

    private static final String FIND_ALL = """
            SELECT * 
            FROM users
            """;

    private static final String UPDATE_USER = """
            UPDATE users
            SET name = ?, last_name = ?, email = ?, age = ?
            WHERE id = ?
            """;

    private static final String DELETE_BY_ID = """
            DELETE
            FROM users
            WHERE id = ?
            """;

    @Override
    public User save(User user) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SAVE_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    user.setId(resultSet.getLong("id"));
                }
            }

            return user;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BY_ID)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    return Optional.of(mapResultSetToUser(resultSet));
                }

                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user by id", e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL)) {

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    return Optional.of(mapResultSetToUser(resultSet));
                }

                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user by email", e);
        }
    }

    @Override
    public List<User> findAll() {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_ALL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                List<User> users = new ArrayList<>();

                while (resultSet.next()) {
                    users.add(mapResultSetToUser(resultSet));
                }

                return users;

            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all users", e);
        }
    }

    @Override
    public User update(User user) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setLong(5, user.getId());

            preparedStatement.executeUpdate();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update user", e);
        }
    }

    @Override
    public void deleteById(Long id) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete user by id", e);
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getInt("age")
        );
    }
}