/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Screen;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.domain.UserScreen;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author mirek
 */
@Stateless
public class UserScreenDaoImpl implements UserScreenDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<UserScreen> findAll() {
        Query query = entityManager.createNamedQuery("findAllUserScreens");
        
        return query.getResultList();
    }

    @Override
    public UserScreen findByUserAndScreen(User user, Screen screen) {
        System.out.println("Pred TypedQuery");
        TypedQuery<UserScreen> userScreenQuery = entityManager.createNamedQuery("findByUserAndScreen", UserScreen.class);
        userScreenQuery.setParameter("user", user);
        userScreenQuery.setParameter("screen", screen);
        
        System.out.println("Pred getResultList");
        List results = userScreenQuery.getResultList();

        System.out.println("Pred return");
        if (results.isEmpty()) {
            return null;
        } else {
            return userScreenQuery.getSingleResult();
        }
    }
        
}
