package by.tms.sweater.model;

import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class Post {

    private int id;
    private String userName;
    private String text;
    private List<Comment> comments;
    private List<String> like;
    private boolean value = false;

    public Post() { }

    public Post(int id, String userName, String text, List<Comment> comments, List<String> like, boolean value) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.comments = comments;
        this.like = like;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments.add(comments);
    }

    public List<String> getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like.add(like);
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Post №" + id + ", " +
                PRINT_NAME + ": " + userName + ", " +
                PRINT_TEXT + ": '" + text + "', " +
                PRINT_COMMENTS + ": " + comments + ", " +
                PRINT_LIKE + ": " + like;
    }

}
