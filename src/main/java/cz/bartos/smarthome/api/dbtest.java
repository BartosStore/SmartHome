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
import cz.bartos.smarthome.domain.Squarizator;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.domain.UserScreen;
import cz.bartos.smarthome.security.PasswordProtector;
import cz.bartos.smarthome.security.PasswordProtectorImpl;
import static java.lang.Long.toHexString;
import java.security.MessageDigest;
import static java.security.MessageDigest.getInstance;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private PasswordProtector passwordProtector;
    
    private MessageDigest messageDigest;
    private String password;
    private String salt;
    private Squarizator squarizator;
    
    @GET
    public Response get() {
        password = "admin";
        salt = "kryton";
        
        squarizator = new Squarizator();
        squarizator.setSnackbar(passwordProtector.hashPassword(password, salt));
        
        return Response.ok(squarizator, MediaType.APPLICATION_JSON).build();
    }
    
}
