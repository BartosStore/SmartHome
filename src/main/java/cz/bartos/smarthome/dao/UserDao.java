package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.User;

/**
 * @author Míra
 */
public interface UserDao {

    public User findByLogin(String login, String password);
}
