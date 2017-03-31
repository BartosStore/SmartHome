/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.api;

import cz.bartos.smarthome.dao.ScreenDao;
import cz.bartos.smarthome.dao.UserDao;
import cz.bartos.smarthome.dao.UserScreenDao;
import cz.bartos.smarthome.domain.Authorizator;
import cz.bartos.smarthome.domain.AuthorizeBean;
import cz.bartos.smarthome.domain.Screen;
import cz.bartos.smarthome.domain.User;
import cz.bartos.smarthome.domain.UserScreen;
import java.sql.Timestamp;
import java.util.Date;
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
 * @author Mira
 */
@Path("authorize")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class Authorize {

    @Inject
    UserDao userDao;
    
    @Inject
    ScreenDao screenDao;
    
    @Inject
    UserScreenDao userScreenDao;
    
    private Authorizator authorizator;
    private User user;
    private Screen screen;
    private UserScreen userScreen;
    
    @POST
    public Response post(final AuthorizeBean input) {
        System.out.println("uuid: " + input.uuid + "\npath: " + input.path);
        
        /* - kontrola naplneni - */
        List<User> users = userDao.findAll();
        if (users.isEmpty()) {System.out.println("NO users");} 
        
        List<Screen> screens = screenDao.findAll();
        if (screens.isEmpty()) {System.out.println("NO screens");} 
        
        /* - hledani uzivatele - */
        user = userDao.findByToken(input.uuid);
        /* - hledani obrazovky - */
        screen = screenDao.findByUrl(input.path);
        
        authorizator = new Authorizator();
        
        if (user != null && screen != null) {
            System.out.println("Authorize -> user != null and screen != null");
            Timestamp now = new Timestamp((new Date()).getTime());
            
            long delta = Math.abs(now.getTime() - user.getLastReading().getTime());
            System.out.println("delta: " + delta + ", now: " + now.getTime() + ", lastR.: " + user.getLastReading().getTime());
            long afk = delta / (1000 * 60);
            System.out.println("afk: " + afk);

            boolean isOnline = afk < 10;
            authorizator.setBlocked(isOnline);
            authorizator.setPath(input.path);
            
            if (isOnline) {
                System.out.println("Authorize -> user is online!");

                user.setLastReading(now);
                userDao.update(user);
                
                authorizator.setAfk(afk);
                authorizator.setIsAFK(false);
                
                /* - hledani userScreen - */
                userScreen = userScreenDao.findByUserAndScreen(user, screen);
                if (userScreen == null) {System.out.println("NO userscreen");}
                
                authorizator.setStatus("ok");
                System.out.println("Blocked z databaze: " + userScreen.isBlocked());
                authorizator.setBlocked(userScreen.isBlocked());
                
                /*
                if (input.path.equals("/lighting")) {
                    System.out.println("HEEEEEY lighting!");
                    authorizator.setStatus("err_access");
                } else {
                    System.out.println("NONONO non lighting!");
                    authorizator.setStatus("ok");
                }
                */
            } else {
                System.out.println("Authorize -> user is AFK!");
                authorizator.setStatus("err_afk");
                authorizator.setIsAFK(true);
                authorizator.setSnackbar("Byli jste neaktivní více jak 30 minut. Opakujte přihlášení.");
            }
        } else {
            System.out.println("Authorize -> UUID not found!" );
            authorizator.setStatus("err");
            authorizator.setSnackbar("Tokenu neodpovídá žádný uživatel.");
        }
        
        return Response.ok(authorizator, MediaType.APPLICATION_JSON).build();
    }
}
