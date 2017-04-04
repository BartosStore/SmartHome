/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Component;
import cz.bartos.smarthome.domain.Screen;
import java.util.List;

/**
 *
 * @author mirek
 */
public interface ComponentDao {
    
    public List<Component> findByScreen(Screen screen);
    
    public Component findComponentById(Long id);
    
    public List<Component> findAll();
    
    public void update(Component component);
    
}
