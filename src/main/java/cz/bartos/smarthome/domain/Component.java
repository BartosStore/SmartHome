/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mirek
 */
@Entity
public class Component implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String cName;
    private String description;
    private String cType;           //button/switcher/slider
    private int value;
    private boolean dashboard;      //true-value se muze zobrazit v DaBo
    private Timestamp lastWriting;  //posledni zapis hodnoty
    private Long fk_screen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDashboard() {
        return dashboard;
    }

    public void setDashboard(boolean dashboard) {
        this.dashboard = dashboard;
    }

    public Timestamp getLastWriting() {
        return lastWriting;
    }

    public void setLastWriting(Timestamp lastWriting) {
        this.lastWriting = lastWriting;
    }

    public Long getFk_screen() {
        return fk_screen;
    }

    public void setFk_screen(Long fk_screen) {
        this.fk_screen = fk_screen;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.bartos.smarthome.domain.Component[ id=" + id + " ]";
    }
    
}
