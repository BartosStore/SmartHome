/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Room;

/**
 *
 * @author Míra
 */
public interface RoomDao {

    public Room merge(Room room);

    public void save(Room room);

    public void delete(Room room);

    public Room findRoomById(Long id);

}
