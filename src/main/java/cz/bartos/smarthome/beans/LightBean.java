/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Míra
 */
@Named
@ViewScoped
public class LightBean implements Serializable {

    private boolean lightSwitcher;
    private String selectedRoom;

    @PostConstruct
    public void init() {
        lightSwitcher = true;
        selectedRoom = "kuchyn";
    }

    public boolean isLightSwitcher() {
        return lightSwitcher;
    }

    public void setLightSwitcher(boolean lightSwitcher) {
        this.lightSwitcher = lightSwitcher;
    }

    public String getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(String selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

}
