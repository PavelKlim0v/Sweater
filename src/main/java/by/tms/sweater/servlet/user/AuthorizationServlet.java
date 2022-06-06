package by.tms.sweater.servlet.user;

import by.tms.sweater.model.User;
import by.tms.sweater.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static by.tms.sweater.constants.Constants.*;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(PRINT_LOGIN);
        String password = req.getParameter(PRINT_PASSWORD);

        User user = userService.findUserByLogin(login);

        if (user == null){
            req.setAttribute("getText", (PRINT_WRONG + PRINT_USER));
            getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);

        } else if (user.getPassword().equals(password) && user.getLogin().equals(login)) {
            req.getSession().setAttribute(PRINT_USER, user);
            getServletContext().getRequestDispatcher(PATH_POST_JSP).forward(req, resp);

        } else {
            req.getSession().setAttribute("getText", (PRINT_WRONG + PRINT_USER));
            getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
        }
    }

}
