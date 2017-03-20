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
@Path("login")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class Login {
    
    @Inject
    UserDao userDao;
    
    private Authenticator authenticator;
    private User user;
    
    @POST
    public Response post(final JaxBean input) {
        //System.out.println("login: " + input.name + "\npass: " + input.pass);
        authenticator = new Authenticator();
        
        user = userDao.findByLogin(input.name, input.pass);
        
        if (user != null) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp);
            
            user.setToken(uuid);
            user.setLastReading(timestamp);
            userDao.update(user);
            
            authenticator.setName(user.getEmail());
            authenticator.setPass(user.getPassword());
            authenticator.setToken(user.getToken());
            authenticator.setTimestamp(timestamp);
        } else {
            authenticator.setName("ERROR");
        }
        
        return Response.ok(authenticator, MediaType.APPLICATION_JSON).build();
    }
}
