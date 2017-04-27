/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Component;
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
public class ComponentDaoImpl implements ComponentDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Component> findByScreen(Screen screen) {
        TypedQuery<Component> componentQuery = entityManager.createNamedQuery("findByScreen", Component.class);
        componentQuery.setParameter("screen", screen);
        
        List<Component> results = componentQuery.getResultList();
        
        if (results.isEmpty()) {
            return null;
        } else {
            return results;
        }
    }

    @Override
    public List<Component> findAll() {
        Query query = entityManager.createNamedQuery("findAllComponents");
        
        return query.getResultList();
    }

    @Override
    public Component findComponentById(Long id) {
        TypedQuery<Component> componentQuery = entityManager.createNamedQuery("findComponentById", Component.class);
        componentQuery.setParameter("id", id);
        
        Component component = componentQuery.getSingleResult();
        
        return component;
    }

    @Override
    public void update(Component component) {
        entityManager.merge(component);
    }


    
}
