/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Míra
 */
@Singleton
public class WebTargetProducer {

    private WebTarget webTarget;

    @PostConstruct
    public void createWebTarget() {

        webTarget = ClientBuilder.newBuilder().build()
                .target("http://httpbin.org/ip");

    }

    @Produces
    public WebTarget getWebTarget() {
        return webTarget;
    }

}
