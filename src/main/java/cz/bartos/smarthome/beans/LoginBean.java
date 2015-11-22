/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.beans;

import cz.bartos.smarthome.dao.UserDao;
import cz.bartos.smarthome.domain.User;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Míra
 */
@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    UserSession userSession;
    private String user;
    private String password;
    @Inject
    private UserDao userDao;

    public String authenticateUser() {
        User databaseUser = userDao.findByLogin(user, password);
        if (databaseUser == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", "Login failed");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        userSession.setUser(databaseUser);

        return "index.xhtml";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
