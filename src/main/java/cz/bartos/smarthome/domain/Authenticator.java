/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

import java.sql.Timestamp;

/**
 *
 * @author Mira
 */
public class Authenticator {
    
    private String status;
    private String name;
    private String pass;
    private String token;
    private Timestamp timestamp;
    private long afk;
    private String snackbar;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSnackbar() {
        return snackbar;
    }

    public void setSnackbar(String snackbar) {
        this.snackbar = snackbar;
    }

    public long getAfk() {
        return afk;
    }

    public void setAfk(long afk) {
        this.afk = afk;
    }

    
}
