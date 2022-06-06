package by.tms.sweater.servlet.user;

import by.tms.sweater.model.User;
import by.tms.sweater.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

@WebServlet("/changeUserRole")
public class ChangeUserRoleServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all = userService.findAllUser();
        req.setAttribute(PRINT_ALL, all);
        getServletContext().getRequestDispatcher(PATH_CHANGEUSERROLE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter(PRINT_USERNAME);

        if (userName == null && userService.findUserByUserName(userName) == null) {
            // if there is no such name
            req.setAttribute("getText", PRINT_NOT_EXIST);
        } else {
            List<User> all = userService.findAllUser();
            req.setAttribute(PRINT_ALL, all);
            req.setAttribute("getText", userService.changeUser(userName));
        }
        getServletContext().getRequestDispatcher(PATH_CHANGEUSERROLE_JSP).forward(req, resp);
    }

}
