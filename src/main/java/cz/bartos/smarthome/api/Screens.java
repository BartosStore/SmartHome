/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.ScreenDao;
import cz.bartos.smarthome.domain.Screen;
import java.util.List;
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
@Path("screens")
@Produces(MediaType.APPLICATION_JSON)
public class Screens {
        
    @Inject
    private ScreenDao screenDao;
    
    @GET
    public Response get() {
        List<Screen> screens = screenDao.findAll();
        
        return Response.ok(screens, MediaType.APPLICATION_JSON).build();
    }

}
