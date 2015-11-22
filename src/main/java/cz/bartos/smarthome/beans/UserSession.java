package cz.bartos.smarthome.beans;

import cz.bartos.smarthome.domain.Role;
import cz.bartos.smarthome.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Míra
 */
@Named
@SessionScoped
public class UserSession implements Serializable {

    private User user;

    public User getUser() {
        return user;
    }

    public boolean hasRole(Role role) {
        return user != null && user.getRole().equals(role);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
