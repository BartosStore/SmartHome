/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.service;

/**
 *
 * @author Míra
 */
public interface RestService {

    public String getIP();

    public String getRules();

    public String getRulesById(int id);

    public String getNodes();

}
