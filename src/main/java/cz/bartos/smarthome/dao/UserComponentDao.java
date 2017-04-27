/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.UserComponent;
import java.util.List;

/**
 *
 * @author mirek
 */
public interface UserComponentDao {

    public List<UserComponent> findAll();
    
}
