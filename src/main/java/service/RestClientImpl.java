/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Míra
 */
@Stateless
public class RestClientImpl implements RestClient {

    private String url = "adresa_API";

    @Override
    public String getIP() {
        Client restClient = ClientBuilder.newClient();
        WebTarget webTarget = restClient.target("http://httpbin.org/ip");

        Response response = webTarget.request().get();
        String result = response.readEntity(String.class);
        return result;
    }

    @Override
    public String getRules() {
        Client restClient = ClientBuilder.newClient();
        WebTarget webTarget = restClient.target(url + "api/v1/rules");

        Response response = webTarget.request().get();
        String result = response.readEntity(String.class);
        return result;
    }

    @Override
    public String getRulesById(int id) {
        Client restClient = ClientBuilder.newClient();
        WebTarget webTarget = restClient.target(url + "api/v1/rules" + id);

        Response response = webTarget.request().get();
        String result = response.readEntity(String.class);
        return result;
    }

    @Override
    public String getNodes() {
        Client restClient = ClientBuilder.newClient();
        WebTarget webTarget = restClient.target(url + "api/v1/nodes/discover");

        Response response = webTarget.request().get();
        String result = response.readEntity(String.class);
        return result;
    }

}
