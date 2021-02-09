package informatique.model;

import informatique.model.User;

public final class UserSession {
    private static UserSession instance;

    private User user;

    private UserSession(User user) {
        this.user = user;
    }

    public static void setInstace(User user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
    }

    public static UserSession getInstace() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void cleanUserSession() {
        user = new User();
        instance = null;
    }

}