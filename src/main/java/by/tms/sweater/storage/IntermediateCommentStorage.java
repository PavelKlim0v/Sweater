package by.tms.sweater.storage;

import by.tms.sweater.model.Comment;
import by.tms.sweater.service.CommentService;
import by.tms.sweater.service.PostService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class IntermediateCommentStorage {

    private static final HashMap<Integer, List<Comment>> hashMap = new HashMap<>();
    private final PostService postService = new PostService();
    private final CommentService commentService = new CommentService();
    private List<Comment> comments;

    public String addCommentIntermediateStorage(int idPost, Comment comment) {
        int sizeMap = hashMap.size() + 1;
        if ((idPost > sizeMap) && idPost <= 0 && comment == null) {
            System.out.println(PRINT_CHECK_METHOD + "addCommentIntermediateStorage");
            return PRINT_NOT_EXIST;
        }
        comments = hashMap.get(idPost);

        if (comments == null) {
            comments = new ArrayList<>();
            comment.setId(BEGINNING_VALUE);
            hashMap.put(idPost, comments);
            hashMap.get(idPost).add(comment);
            postService.addCommentByPost(idPost, comment);

        } else {
            comment.setId(comments.size() + 1);
            postService.addCommentByPost(idPost, comment);
            hashMap.get(idPost).add(comment);
        }
        return String.valueOf(comment);
    }

    public String editCommentIntermediateStorage(int idPost, int idComment, String text, String userName) {
        comments = hashMap.get(idPost);
        if (idPost <= 0 && idComment <= 0 && text == null && userName == null && comments == null) {
            System.out.println(PRINT_CHECK_METHOD + "editCommentIntermediateStorage");
            return null;
        }
        for (Comment item : comments) {
            if (item != null && item.getId() == idComment) {
                item.setText(text);
                return String.valueOf(item);
            }
        }
        return null;
    }

    public String deleteCommentIntermediateStorage(int idPost, int idComment, String userName) {
        comments = hashMap.get(idPost);
        if (idPost <= 0 && idComment <= 0 && userName == null && comments == null) {
            System.out.println(PRINT_CHECK_METHOD + "deleteCommentIntermediateStorage");
            return null;
        }
        for (Comment item : comments) {
            if (item != null && item.getId() == idComment) {
                commentService.remove(item, userName);
                postService.removeCommentByPost(idPost, item, userName);
                hashMap.get(idPost).remove(item);
                return PRINT_DELETED;
            }
        }
        return null;
    }

}
