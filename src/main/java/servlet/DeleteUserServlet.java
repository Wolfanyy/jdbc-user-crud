package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.AppContext;

import java.io.IOException;

@WebServlet("/users/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = AppContext.getUserService();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        userService.deleteById(id);

        response.sendRedirect(request.getContextPath() + "/users");
    }

}
