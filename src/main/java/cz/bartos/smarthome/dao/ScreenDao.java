/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import cz.bartos.smarthome.domain.Screen;
import java.util.List;

/**
 *
 * @author mirek
 */
public interface ScreenDao {
    
    public Screen findByUrl(String url);
    
    public List<Screen> findAll();
    
}
