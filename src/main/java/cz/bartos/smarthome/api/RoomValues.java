/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.domain.RoomState;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mira
 */
@Path("room_values")
@Produces(MediaType.APPLICATION_JSON)
public class RoomValues {
    
    private RoomState state;
    
    @GET
    public Response get() {
        state = new RoomState();
        state.setId("1");
        state.setName("Kuchyn");
        state.setTemp("22.8");
        state.setHumi("58.5");
        
        return Response
                .ok(state, MediaType.APPLICATION_JSON).build();
        
        //.ok(state, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
    }
    
}
