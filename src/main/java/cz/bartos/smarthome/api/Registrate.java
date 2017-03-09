/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.UserDao;
import cz.bartos.smarthome.domain.Authenticator;
import cz.bartos.smarthome.domain.JaxBean;
import cz.bartos.smarthome.domain.User;
import java.sql.Timestamp;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mira
 */
@Path("registrate")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class Registrate {
    
    @Inject
    UserDao userDao;
    
    @POST
    public Response registrate(final JaxBean input) {
        
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        user.setEmail(input.name);
        user.setName(input.name);
        user.setPassword(input.pass);
        user.setToken(uuid);
        user.setLastReading(timestamp);
        
        userDao.addUser(user);
        
        Authenticator authenticator = new Authenticator();
        authenticator.setName(input.name);
        authenticator.setPass("password");
        authenticator.setToken(uuid);
        authenticator.setTimestamp("timestamp");

        return Response.ok(authenticator, MediaType.APPLICATION_JSON).build();        
    }
}
