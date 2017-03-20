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
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mira
 */
@Path("authorize")
@Produces(MediaType.APPLICATION_JSON)
public class Authorize {

    @Inject
    UserDao userDao;
    
    private Authenticator authenticator;
    private String box;
    
    @GET
    public Response post() {
        
        box = "admin";
        
        User user = new User();
        user = userDao.findByToken(box);
        
        user.setSurname("merge");
        userDao.update(user);
        //user = userDao.findByLogin("admin", "admin");
        
        /*
        authenticator = new Authenticator();
        
        if (user == null) {
            authenticator.setName("error");
        } else {
            authenticator.setName("OK");
            authenticator.setPass(box);
        }
        */
        
        return Response.ok(user, MediaType.APPLICATION_JSON).build();
    }
}
