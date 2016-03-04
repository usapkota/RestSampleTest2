package org.sample.rest.RestSampleTest.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sample.rest.RestSampleTest.model.MeasureCategory;
import org.sample.rest.RestSampleTest.service.MeasureCategoryService;



@Path("/measures")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MeasureCategoryResource {
	
	MeasureCategoryService measureservice = new MeasureCategoryService();
	
	//get all users
	@GET
	public List<MeasureCategory> getAllUsersInXML() {
        return measureservice.getAllUsers();
    } 

	//test
	@GET
	@Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "This is measure Category!";
    }
}
