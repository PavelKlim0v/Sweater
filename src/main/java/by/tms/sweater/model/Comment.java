package by.tms.sweater.model;

import static by.tms.sweater.constants.Constants.*;

public class Comment {

    private int id;
    private String userName;
    private String text;

    public Comment() { }

    public Comment(int id, String userName, String text) {
        this.id = id;
        this.userName = userName;
        this.text = text;
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

    @Override
    public String toString() {
        return "{№" + id + ", " +
                PRINT_NAME + ": " + userName + ", " +
                PRINT_TEXT + ": '" + text + "'}";
    }

}
