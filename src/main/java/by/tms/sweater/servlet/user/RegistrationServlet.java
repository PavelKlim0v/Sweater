package by.tms.sweater.servlet.user;

import by.tms.sweater.model.Admin;
import by.tms.sweater.model.User;
import by.tms.sweater.model.UserRole;
import by.tms.sweater.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static by.tms.sweater.constants.Constants.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void init() {
        if (Admin.mainAdmin == 0) {
            userService.add(Admin.getDataAdmin());
            Admin.mainAdmin++;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(PRINT_NAME);
        String login = req.getParameter(PRINT_LOGIN);
        String password = req.getParameter(PRINT_PASSWORD);

        UserRole roleForUser = UserRole.USER_ROLE;
        User user = new User(name, login, password, roleForUser);
        boolean isAdded = userService.add(user);

        if (isAdded) {
            getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
        } else {
            req.setAttribute("getText", PRINT_ALREADY_USE);
            getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        }
    }

}
