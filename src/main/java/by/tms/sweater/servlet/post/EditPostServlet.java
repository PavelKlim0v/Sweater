package by.tms.sweater.servlet.post;

import by.tms.sweater.model.User;
import by.tms.sweater.service.PostService;
import by.tms.sweater.service.UserService;
import by.tms.sweater.storage.IntermediatePostStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static by.tms.sweater.constants.Constants.*;

@WebServlet("/editPost")
public class EditPostServlet extends HttpServlet {

    private final IntermediatePostStorage intermediatePostStorage = new IntermediatePostStorage();
    private final PostService postService = new PostService();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(PATH_POST_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter(PRINT_IDPOST));
        String text = req.getParameter(PRINT_TEXT);
        String userName = req.getParameter(PRINT_USERNAME);

        User user = (User) req.getSession().getAttribute(PRINT_USER);
        if (userName == null) { userName = user.getName(); }

        if (userService.findUserByUserName(userName) == null) {
            // if there is no such name
            req.setAttribute("getText", PRINT_NOT_EXIST);
        } else if (postService.find(idPost, userName) == null) {
            // if there is no such id
            req.setAttribute("getText", PRINT_NOT_EXIST);
        } else {
            String getText = intermediatePostStorage.editPostIntermediateStorage(idPost, text, userName);
            req.setAttribute("getText", getText);
        }
        getServletContext().getRequestDispatcher(PATH_POST_JSP).forward(req, resp);
    }

}
