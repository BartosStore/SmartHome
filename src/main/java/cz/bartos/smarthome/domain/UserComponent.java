/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mirek
 */
@Entity
public class UserComponent implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long fk_user;
    private Long fk_component;
    private boolean blocked;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFk_user() {
        return fk_user;
    }

    public void setFk_user(Long fk_user) {
        this.fk_user = fk_user;
    }

    public Long getFk_component() {
        return fk_component;
    }

    public void setFk_component(Long fk_component) {
        this.fk_component = fk_component;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserComponent)) {
            return false;
        }
        UserComponent other = (UserComponent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.bartos.smarthome.domain.UserComponent[ id=" + id + " ]";
    }
    
}
