/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Room;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Míra
 */
@Stateless
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Room merge(Room room) {
        return manager.merge(room);
    }

    @Override
    public void save(Room room) {
        manager.persist(room);
    }

    @Override
    public void delete(Room room) {
        manager.remove(room);
    }

    @Override
    public Room findRoomById(Long id) {
        return manager.find(Room.class, id);
    }

}
