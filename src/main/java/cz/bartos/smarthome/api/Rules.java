package cz.bartos.smarthome.api;

import cz.bartos.smarthome.domain.RulesEntity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mira
 */
@Path("rules")
@Produces(MediaType.APPLICATION_JSON)
public class Rules {
    
    private RulesEntity rules;
    
    @GET
    public Response get() {
        rules = new RulesEntity();
        
        rules.setActionAddDate("1453683780000");
        rules.setActionChannel("1");
        rules.setActionData("1");
        rules.setActionNodeAddress("1");
        rules.setActionNodeTitle("Svetlo");
        rules.setDate("1453683780000");
        rules.setDescription("m");
        rules.setEvaluationAddDate("1453683780000");
        rules.setEvaluationChannel("1");
        rules.setEvaluationCondition(">");
        rules.setEvaluationNodeAddress("2");
        rules.setEvaluationNodeTitle("Tlakomer");
        rules.setEvaluationValue("50");
        rules.setId("1");
        rules.setTitle("Test1");
               
        //return Response.ok(rules.toString()).build();
        //return Response.ok(rules, MediaType.APPLICATION_JSON).build();
        return Response
                .ok(rules, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
    }
    
}
