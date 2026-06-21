package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import util.AppContext;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = AppContext.getUserService();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.findAll();

        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/jsp/users.jsp")
                .forward(request, response);
    }
}