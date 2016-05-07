/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.producer;

import cz.bartos.smarthome.domain.User;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Míra
 */
@Named
@RequestScoped
public class UserProducer implements Serializable {

    public User produceSpecimenUser() {
        User user = new User();
        //user.setRole("nejaka role");
        return user;
    }

}
