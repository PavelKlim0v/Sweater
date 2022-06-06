package by.tms.sweater.service;

import by.tms.sweater.model.User;
import by.tms.sweater.model.UserRole;
import by.tms.sweater.storage.UserStorage;
import java.util.List;
import static by.tms.sweater.constants.Constants.PRINT_DONE;

public class UserService {

    private static final UserStorage userStorage = new UserStorage();

    public boolean add(User user) {
        if (user == null) { return false; }
        if (userStorage.isExistsByLogin(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public User findUserByUserName(String name) {
        if (name != null) {
            return userStorage.findByUserName(name);
        }
        return null;
    }

    public User findUserByLogin(String login) {
        if (userStorage.findByLogin(login) != null && login != null) {
            return userStorage.findByLogin(login);
        }
        return null;
    }

    public List<User> findAllUser() {
        return userStorage.getAllUser();
    }

    public String changeUser(String login) {
        User user = findUserByLogin(login);
        user.setRole(UserRole.ADMIN_ROLE);
        return PRINT_DONE;
    }

}
