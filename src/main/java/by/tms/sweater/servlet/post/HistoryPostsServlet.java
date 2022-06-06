package by.tms.sweater.servlet.post;

import by.tms.sweater.model.Post;
import by.tms.sweater.model.User;
import by.tms.sweater.service.PostService;
import by.tms.sweater.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

@WebServlet("/postHistory")
public class HistoryPostsServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(PRINT_USER);
        List<Post> all = postService.findAll(user.getName());
        req.setAttribute(PRINT_ALL, all);
        getServletContext().getRequestDispatcher(PATH_HISTORY_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter(PRINT_USERNAME);
        User user = (User) req.getSession().getAttribute(PRINT_USER);
        if (userName == null) { userName = user.getName(); }

        if (userService.findUserByUserName(userName) == null) {
            // if there is no such name
            req.setAttribute("getText", PRINT_NOT_EXIST);
        } else {
            List<Post> all = postService.findAll(userName);
            req.setAttribute(PRINT_ALL, all);
        }
        getServletContext().getRequestDispatcher(PATH_HISTORY_JSP).forward(req, resp);
    }

}
