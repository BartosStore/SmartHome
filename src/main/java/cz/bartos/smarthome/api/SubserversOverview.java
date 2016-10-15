package cz.bartos.smarthome.api;

import cz.bartos.smarthome.domain.SubserversOverviewEntity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mira
 */
@Path("subservers_overview")
public class SubserversOverview {
    
    private SubserversOverviewEntity subserversOverview;
    
    @GET
    public Response get() {
        subserversOverview = new SubserversOverviewEntity();
        
        subserversOverview.setId("1");
        subserversOverview.setTitle("Kuchyn");
        subserversOverview.setLocation("U lednice");
        subserversOverview.setAddress("111");
        subserversOverview.setDescription("V kuchyni");
        subserversOverview.setAddDate("1454411993000");
        
        return Response.ok(subserversOverview.toString()).build();
    }
}
