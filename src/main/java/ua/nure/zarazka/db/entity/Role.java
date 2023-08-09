package ua.nure.zarazka.db.entity;

/**
 * @author @author Evgeny Norkin
 */
public enum Role {
    ADMIN, CLIENT;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        return Role.values()[--roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}