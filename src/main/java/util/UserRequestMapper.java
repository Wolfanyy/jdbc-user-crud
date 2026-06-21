package util;

import jakarta.servlet.http.HttpServletRequest;
import model.User;

public class UserRequestMapper {

    private UserRequestMapper() {
    }

    public static User buildUser(HttpServletRequest request) {

        User user = new User();

        String id = request.getParameter("id");

        if (id != null && id.isBlank()) {
            user.setId(Long.parseLong(id));
        }

        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        return user;
    }
}
