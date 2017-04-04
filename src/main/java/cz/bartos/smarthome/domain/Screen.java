/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author mirek
 */
@NamedQueries(
        {
            @NamedQuery(name = "findAllScreens", query = "SELECT s FROM Screen s"),
            @NamedQuery(name = "findByUrl", query = "SELECT s FROM Screen s WHERE s.url = :url")
        }
)
@Entity
public class Screen implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String sName;
    private String url;
    
    @OneToMany(cascade = CascadeType.MERGE)
    private List<UserScreen> userScreens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserScreen> getUserScreens() {
        return userScreens;
    }

    public void setUserScreens(List<UserScreen> userScreens) {
        this.userScreens = userScreens;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screen)) {
            return false;
        }
        Screen other = (Screen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.bartos.smarthome.domain.Screen[ id=" + id + " ]";
    }
    
}