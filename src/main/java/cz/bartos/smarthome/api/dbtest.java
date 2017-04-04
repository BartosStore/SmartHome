/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.ScreenDao;
import cz.bartos.smarthome.dao.UserDao;
import cz.bartos.smarthome.dao.UserScreenDao;
import cz.bartos.smarthome.domain.Screen;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.domain.UserScreen;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mirek
 */
@Path("dbtest")
@Produces(MediaType.APPLICATION_JSON)
public class dbtest {
    
    @Inject
    private UserDao userDao;
    
    @Inject
    private ScreenDao screenDao;
    
    @Inject
    private UserScreenDao userScreenDao;
    
    private User user;
    private Screen screen;
    private UserScreen userScreen;
    
    @GET
    public Response get() {
        user = userDao.findByLogin("admin", "admin");
        
        if (user == null) {
            System.out.println("USER IS NULL"); 
        }
        
        screen = screenDao.findByUrl("/heating");
        
        if (screen == null) {
            System.out.println("SCREEN IS NULL"); 
        }
        
        System.out.println("USER and SCREEN OK");
        
        /*
        userScreen = new UserScreen();
        userScreen.setUser(user);
        userScreen.setScreen(screen);
        */
        
        userScreen = userScreenDao.findByUserAndScreen(user, screen);
        
        System.out.println("USERSCREEN OK");

        return Response
                .ok(userScreen, MediaType.APPLICATION_JSON).build();
    }
}
