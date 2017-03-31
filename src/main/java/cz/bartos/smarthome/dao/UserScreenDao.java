/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Screen;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.domain.UserScreen;
import java.util.List;

/**
 *
 * @author mirek
 */
public interface UserScreenDao {

    public UserScreen findByUserAndScreen(User user, Screen screen);
    
    public List<UserScreen> findAll();
    
}
