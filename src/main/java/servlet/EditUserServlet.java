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

@WebServlet("/users/edit")
public class EditUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = AppContext.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        User user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/jsp/edit-user.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();

        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        userService.update(user);

        response.sendRedirect(request.getContextPath() + "/users");
    }
}
