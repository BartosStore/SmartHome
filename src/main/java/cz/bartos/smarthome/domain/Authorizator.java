/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

/**
 *
 * @author mirek
 */
public class Authorizator {

    private String status;
    private String path;
    private boolean isAFK;
    private long afk;
    private boolean blocked;
    private String snackbar;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isIsAFK() {
        return isAFK;
    }

    public void setIsAFK(boolean isAFK) {
        this.isAFK = isAFK;
    }

    public long getAfk() {
        return afk;
    }

    public void setAfk(long afk) {
        this.afk = afk;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getSnackbar() {
        return snackbar;
    }

    public void setSnackbar(String snackbar) {
        this.snackbar = snackbar;
    }
    
}
