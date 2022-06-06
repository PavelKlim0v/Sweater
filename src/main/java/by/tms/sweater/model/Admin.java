package by.tms.sweater.model;

import static by.tms.sweater.model.UserRole.ADMIN_ROLE;

public class Admin {

    private static final String ADMIN_DATA_NAME = "Administrator";
    private static final String ADMIN_DATA_LOGIN = "hardLogin";
    private static final String ADMIN_DATA_PASSWORD = "hardPassword";
    private static final UserRole ADMIN_DATA_ROLE = ADMIN_ROLE;
    public static byte mainAdmin;

    public static User getDataAdmin() {
        return new User(ADMIN_DATA_NAME, ADMIN_DATA_LOGIN, ADMIN_DATA_PASSWORD, ADMIN_DATA_ROLE);
    }

}
