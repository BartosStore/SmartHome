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
import java.util.Date;
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
    
    @POST
    //public Response post() {                
    //public Response post(@FormParam("name") String name) {
    public Response post(final JaxBean input) {
        System.out.println(
                "login: " + input.name
                + "\npass: " + input.pass
            );
        
        /*
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        */
        
        //authenticator.setTimestamp(String.valueOf(timestamp.getTime()));
        
        User user = new User();
        user = userDao.findByLogin(input.name, input.pass);
        //user = userDao.findByLogin("mira", "mypass");
        authenticator = new Authenticator();
        
        if (!user.getEmail().equals("")) {
            System.out.println(
                "login: " + user.getEmail()
                + "\npass: " + user.getPassword()
            );
            
            authenticator.setName(user.getEmail());
            authenticator.setPass(user.getPassword());
            authenticator.setToken(user.getToken());
        } else {
            System.out.println("User nenalezen.");
            authenticator.setName("ERROR");
        }
        
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        
        return Response.ok(authenticator, MediaType.APPLICATION_JSON).build();
    }
}
