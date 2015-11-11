package cz.bartos.smarthome.beans;

import cz.bartos.smarthome.dao.RoomDao;
import cz.bartos.smarthome.domain.Room;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Míra
 */
@Named
@ViewScoped
public class HomeBean implements Serializable {

    private String room = "Obyvak";
    @Inject
    private RoomDao roomDao;
    private Room newRoom;

    @PostConstruct
    public void init() {
        newRoom = new Room();
        newRoom.setName("Kuchyn");
        /*newRoom.setTemp(20);*/

        roomDao.save(newRoom);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
