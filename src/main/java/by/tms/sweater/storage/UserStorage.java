package by.tms.sweater.storage;

import by.tms.sweater.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static final List<User> users = new ArrayList<>();

    public List<User> getAllUser() {
        return new ArrayList<>(users);
    }

    public void save(User user) {
        users.add(user);
    }

    public User findByUserName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User findByLogin(String login) {
        for (User user : users) {
            if (user != null && user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean isExistsByLogin(String login) {
        for (User user : users) {
            if (user != null && user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
