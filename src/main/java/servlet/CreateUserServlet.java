package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import util.AppContext;
import util.UserRequestMapper;

import java.io.IOException;

@WebServlet("/users/create")
public class CreateUserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = AppContext.getUserService();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/create-user.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        User user = UserRequestMapper.buildUser(request);

        userService.save(user);

        response.sendRedirect(request.getContextPath() + "/users");
    }
}