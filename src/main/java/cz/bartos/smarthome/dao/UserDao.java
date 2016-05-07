package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.User;
import java.util.List;

/**
 * @author Míra
 */
public interface UserDao {

    public User findByLogin(String login, String password);

    public List<User> findAll();

    public void addUser(User user);

}
