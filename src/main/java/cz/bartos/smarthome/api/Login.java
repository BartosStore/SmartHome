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
import cz.bartos.smarthome.security.PasswordProtector;
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
    
    private static final String SALT = "kryton";
    
    @Inject
    UserDao userDao;
    
    @Inject
    private PasswordProtector passwordProtector;
    
    private Authenticator authenticator;
    private User user;
    private String hashedPassword;
    
    @POST
    public Response post(final JaxBean input) {
        System.out.println("login: " + input.name + "\npass: " + input.pass);
        
        authenticator = new Authenticator();
        hashedPassword = passwordProtector.hashPassword(input.pass, SALT);
        user = userDao.findByLogin(input.name, hashedPassword);
        
        if (user != null) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("OK: " + uuid + "_" + timestamp);
            
            user.setToken(uuid);
            user.setLastReading(timestamp);
            userDao.update(user);
            
            authenticator.setStatus("OK");
            authenticator.setName(user.getEmail());
            authenticator.setPass(user.getPassword());
            authenticator.setToken(user.getToken());
            authenticator.setTimestamp(user.getLastReading());
        } else {
            System.out.println("KO");
            authenticator.setStatus("KO");
            authenticator.setSnackbar("Údajům neodpovídá žádný uživatel.");
        }
        
        return Response.ok(authenticator, MediaType.APPLICATION_JSON).build();
    }
}
