package validation;

import exception.ValidationException;
import model.User;

import java.util.regex.Pattern;

public class UserValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(
                    "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
            );

    public void validate(User user) {

        if (user == null) {
            throw new ValidationException("User cannot be null");
        }

        normalize(user);

        validateName(user.getName());
        validateLastName(user.getLastName());
        validateEmail(user.getEmail());
        validateAge(user.getAge());
    }


    private void normalize(User user) {
        user.setName(user.getName() != null ? user.getName().trim() : null);
        user.setLastName(user.getLastName() != null ? user.getLastName().trim() : null);
        user.setEmail(user.getEmail() != null ? user.getEmail().trim().toLowerCase() : null);
    }

    private void validateName(String name) {

        if (name == null || name.isBlank()) {
            throw new ValidationException("Name cannot be empty");
        }

        if (name.length() < 3 || name.length() > 30) {
            throw new ValidationException("Name must be between 3 and 30");
        }

        if (!name.matches("^[A-Za-zА-Яа-яЁё\\s-]+$")) {
            throw new ValidationException("Name contains invalid characters");
        }
    }

    private void validateLastName(String lastName) {

        if (lastName == null || lastName.isBlank()) {
            throw new ValidationException("Last name cannot be empty");
        }

        if (lastName.length() < 3 || lastName.length() > 30) {
            throw new ValidationException("Last name must be between 3 and 30");
        }

        if (!lastName.matches("^[A-Za-zА-Яа-яЁё\\s-]+$")) {
            throw new ValidationException("Last name contains invalid characters");
        }
    }

    private void validateEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new ValidationException("Email cannot be empty");
        }

        if (email.length() > 50) {
            throw new ValidationException("Email must be between 10 and 50");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException("Email contains invalid characters");
        }
    }

    private void validateAge(Integer age) {

        if (age == null) {
            throw new ValidationException("Age cannot be null");
        }

        if (age < 1 || age > 100) {
            throw new ValidationException("Age must be between 0 and 100");
        }
    }
}