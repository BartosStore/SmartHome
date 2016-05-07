package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.User;
import java.util.List;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author Míra
 */
@Stateless
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByLogin(String login, String password) {
        TypedQuery<User> userQuery = entityManager.createNamedQuery("findUserByLoginQuery", User.class);
        userQuery.setParameter("email", login);
        userQuery.setParameter("password", password);

        List results = userQuery.getResultList();

        if (results.isEmpty()) {
            return null;
        } else {
            return userQuery.getSingleResult();
        }
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createNamedQuery("findAllUsers");

        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

}
