package by.tms.sweater.model;

import static by.tms.sweater.constants.Constants.*;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private UserRole role;

    public User() { }

    public User(String name, String login, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                PRINT_NAME + "='" + name + "', " +
                PRINT_LOGIN + "='" + login + "', " +
                PRINT_PASSWORD + "='" + password + "', " +
                PRINT_ROLE + "=" + role + '}';
    }

}
