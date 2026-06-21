package filter;

import exception.ServiceException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class ExceptionHandlerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        try {

            chain.doFilter(request, response);

        } catch (ServiceException e) {

            request.setAttribute("error", e.getMessage());

            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                    .forward(request, response);
        } catch (Exception e) {

            request.setAttribute("error",
                    "An unexpected error occurred. Please try again later.");

            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                    .forward(request, response);
        }
    }
}
