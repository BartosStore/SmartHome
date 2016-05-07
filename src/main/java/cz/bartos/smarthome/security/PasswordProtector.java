/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.security;

/**
 *
 * @author Míra
 */
public interface PasswordProtector {

    public String hashPassword(String plaintextPass, String salt);

}
