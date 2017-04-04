/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.ComponentDao;
import cz.bartos.smarthome.dao.ScreenDao;
import cz.bartos.smarthome.domain.AuthorizeBean;
import cz.bartos.smarthome.domain.Component;
import cz.bartos.smarthome.domain.Screen;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mirek
 */
@Path("components")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class Components {
    
    @Inject
    ComponentDao componentDao;
    
    @Inject
    private ScreenDao screenDao;
    
    private Screen screen;
    
    @POST
    public Response post(final AuthorizeBean input) {
        System.out.println("uuid: " + input.uuid + "\npath: " + input.path);
        
        screen = screenDao.findByUrl(input.path);
        if (screen == null) {System.out.println("SCREEN IS NULL");}
        
        List<Component> components = componentDao.findByScreen(screen);
        if (components.isEmpty()) {
            System.out.println("COMPONENTS IS EMPTY");
        } else {
            System.out.println("Component no1: " + components.get(0).getcName());
        }
        
        return Response.ok(components, MediaType.APPLICATION_JSON).build();
    }
    
}
