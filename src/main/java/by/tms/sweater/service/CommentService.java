package by.tms.sweater.service;

import by.tms.sweater.model.Comment;
import by.tms.sweater.storage.CommentStorage;

public class CommentService {

    private static final CommentStorage commentStorage = new CommentStorage();

    public int getId() {
        return commentStorage.getId();
    }

    public void create(int id, String userName, String text) {
        if (id <= 0 && userName == null && userName.equals("") && text == null && text.equals("")) {
            return;
        }
        commentStorage.save(new Comment(id, userName, text));
    }

    public Comment find(int id, String userName) {
        return commentStorage.find(id, userName);
    }

    public void remove(Comment comment, String userName) {
        commentStorage.remove(comment, userName);
    }

}

