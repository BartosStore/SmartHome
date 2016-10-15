/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Míra
 */
@Stateless
public class RestServiceImpl implements RestService {

    private String url = "adresa_API";

    @Inject
    private WebTarget webTarget;

    @Override
    public String getIP() {
        return webTarget.request().buildGet()
                .invoke().readEntity(String.class);
    }

    @Override
    public String getRules() {
        //(url + "api/v1/rules");
        return webTarget.path("/rules").request().buildGet()
                .invoke().readEntity(String.class);
    }

    @Override
    public String getRulesById(int id) {
        //(url + "api/v1/rules" + id);
        return webTarget.path("/rules").request().buildGet()
                .invoke().readEntity(String.class);
    }

    @Override
    public String getNodes() {
        //(url + "api/v1/nodes/discover");
        return webTarget.path("/rules").request().buildGet()
                .invoke().readEntity(String.class);

    }

}
