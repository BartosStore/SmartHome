/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.UserComponent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mirek
 */
@Stateless
public class UserComponentDaoImpl implements UserComponentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserComponent> findAll() {
        Query query = entityManager.createNamedQuery("findAllUsercomponents");
        
        return query.getResultList();
    }

}
