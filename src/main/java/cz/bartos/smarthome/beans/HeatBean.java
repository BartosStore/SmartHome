/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import service.RestService;

/**
 *
 * @author Míra
 */
@Named
@ViewScoped
public class HeatBean implements Serializable {

    private int heatTemp;
    private String heatRoom;
    private String restApiResponse;

    @Inject
    private RestService restClient;

    @PostConstruct
    public void init() {
        heatTemp = 20;
        heatRoom = "obyvak";

        String test = restClient.getIP();
        restApiResponse = test.toString();
        System.out.println(test);
    }

    public int getHeatTemp() {
        return heatTemp;
    }

    public void setHeatTemp(int heatTemp) {
        this.heatTemp = heatTemp;
    }

    public String getHeatRoom() {
        return heatRoom;
    }

    public void setHeatRoom(String heatRoom) {
        this.heatRoom = heatRoom;
    }

    public String getRestApiResponse() {
        return restApiResponse;
    }

    public void setRestApiResponse(String restApiResponse) {
        this.restApiResponse = restApiResponse;
    }

    public RestService getRestClient() {
        return restClient;
    }

    public void setRestClient(RestService restClient) {
        this.restClient = restClient;
    }

}
