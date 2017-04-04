/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.ComponentDao;
import cz.bartos.smarthome.domain.Component;
import cz.bartos.smarthome.domain.SquareBean;
import cz.bartos.smarthome.domain.Squarizator;
import java.sql.Timestamp;
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
@Path("sldrsquare")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class SldrSquare {
    
    @Inject
    private ComponentDao componentDao;
    
    private Component component;
    private Squarizator squarizator;
    
    @POST
    public Response post(final SquareBean input) {
        System.out.println("SldrSquare -> id: " + input.id + "\nvalue: " + input.value);
        
        component = componentDao.findComponentById(input.id);
        component.setLastWriting(new Timestamp(System.currentTimeMillis()));
        component.setValue(input.value);
        componentDao.update(component);
        
        squarizator.setStatus("OK");
        squarizator.setSnackbar("Akce byla zaznamenána.");

        return Response.ok(squarizator, MediaType.APPLICATION_JSON).build();
    }
            
}
