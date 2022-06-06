package by.tms.sweater.storage;

import by.tms.sweater.model.Comment;
import java.util.ArrayList;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class CommentStorage {

    private static final List<Comment> comments = new ArrayList<>();

    public int getId() {
        return comments.size() + 1;
    }

    public void save(Comment comment) {
        comments.add(comment);
    }

    public Comment find(int id, String userName) {
        if (id <= 0) { return null; }
        for (Comment item : comments) {
            if (item != null && item.getId() == id && item.getId() > 0 && userName.equals(item.getUserName())) {
                return item;
            }
        }
        return null;
    }

    public void remove(Comment comment, String userName) {
        if (comment == null && userName == null) {
            System.out.println(PRINT_WRONG + " " + PRINT_USER);
            return;
        }
        int index = 0;
        for (Comment item : comments) {
            if (item.equals(comment)) {
                comments.remove(comments.get(index));
                return;
            }
            index++;
        }
    }

}
