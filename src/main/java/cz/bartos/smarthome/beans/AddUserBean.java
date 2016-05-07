/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.beans;

import cz.bartos.smarthome.dao.UserDao;
import cz.bartos.smarthome.domain.Role;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.producer.UserProducer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Míra
 */
@Named
@ViewScoped
public class AddUserBean implements Serializable {

    @Inject
    private UserDao userDao;
    private List<User> users;
    private User newUser;
    private UserProducer userProducer;
    //private List<Role> userRoles = new ArrayList<>();

    @PostConstruct
    public void init() {
        //zde bude potreba pridat roli
        newUser = new User();
        /*
         Role userRole = new Role();
         userRoles.add(userRole);
         */
    }

    /**
     * Creates a new instance of AddUserBean
     */
    public String submitUser() {
        //prirazeni role

        /*
         newUser = new User();
         newUser.setName("milan");
         newUser.setSurname("kostak");
         newUser.setEmail("milan");
         newUser.setPassword("milan");
         */
        userDao.addUser(newUser);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Výborně!", "Váš nový uživatel byl zaregistrován!");
        FacesContext.getCurrentInstance().addMessage(null, message);

        return "index";
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    /*
     public List<Role> getUserRoles() {
     return userRoles;
     }

     public void setUserRoles(List<Role> userRoles) {
     this.userRoles = userRoles;
     }
     */
}
