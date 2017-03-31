/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Screen;
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
public class ScreenDaoImpl implements ScreenDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Screen> findAll() {
        Query query = entityManager.createNamedQuery("findAllScreens");
        
        return query.getResultList();
    }

    @Override
    public Screen findByUrl(String url) {
        TypedQuery<Screen> screenQuery = entityManager.createNamedQuery("findByUrl", Screen.class);
        screenQuery.setParameter("url", url);
        
        List results = screenQuery.getResultList();
        
        if (results.isEmpty()) {
            return null;
        } else {
            return screenQuery.getSingleResult();
        }
    }
    
}
