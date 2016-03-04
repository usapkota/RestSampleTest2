package org.sample.rest.RestSampleTest.resource;

import java.util.Collection;
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

import org.sample.rest.RestSampleTest.model.ClientMeasure;
import org.sample.rest.RestSampleTest.model.ClientMeasureId;
import org.sample.rest.RestSampleTest.service.ClientMeasureService;




@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientMeasureResource {
	
	ClientMeasureService clientservice = new ClientMeasureService();
	
	//get all users
	@GET
	@Path("/getAllUsers")
	public Collection<ClientMeasure> getAllClientsInXML() {
        return  clientservice.getAllUsers();
    } 

//	  // single user by Id
	  @GET
	  @Path("/{id}/{subid}/{meas_sk}/{pop_id}")
	  public ClientMeasure getUserByIdJSON(@PathParam("id")int id,@PathParam("subid") String subid,@PathParam("meas_sk")int meas_sk,@PathParam("pop_id")int pop_id ){
	      return clientservice.getUserByID(id, subid, meas_sk, pop_id);
	  }
	
	  // insert new user
	  @POST
	  public String saveUser(ClientMeasure clientmeasure){
		  if (!clientservice.saveUser(clientmeasure)){
			  return "{\"status\":\"ok\"}"; 
		  }
		  else {
			  return "{\"status\":\" not ok\"}";
		  }
		  
	  } 
	  
	  //update new user
	  @PUT
	  @Path("/{id}/{subid}/{meas_sk}/{pop_id}")
	  public String updateUser(@PathParam("id")short id,@PathParam("subid") String subid,@PathParam("meas_sk")short meas_sk,@PathParam("pop_id")int pop_id, ClientMeasure clientmeasure ){
		 ClientMeasureId cid = new ClientMeasureId();
		  cid.setClientId(id);
		  cid.setClientSubId(subid);
		  cid.setMeasSk(meas_sk);
		  cid.setPopulationIdentifier(pop_id);
		  
		  clientmeasure.setId(cid);
		  
		  if (!clientservice.saveUser(clientmeasure)){
			  return "{\"status\":\"ok\"}"; 
		  }
		  else {
			  return "{\"status\":\" not ok\"}";
		  }
		  
	  }
	  
	
	  //delete new user 
	  @DELETE
	  @Path("/{id}/{subid}/{meas_sk}/{pop_id}")
	  public String deleteUser(@PathParam("id")short id,@PathParam("subid") String subid,@PathParam("meas_sk")short meas_sk,@PathParam("pop_id")int pop_id){
			 ClientMeasureId cid = new ClientMeasureId();
			  cid.setClientId(id);
			  cid.setClientSubId(subid);
			  cid.setMeasSk(meas_sk);
			  cid.setPopulationIdentifier(pop_id);
			  
			  ClientMeasure clientmeasure = new ClientMeasure();
			  clientmeasure.setId(cid);
		  
		  if (!clientservice.deleteUser(clientmeasure)){
			  return "{\"status\":\"ok\"}"; 
		  }
		  else {
			  return "{\"status\":\" not ok\"}";
		  }
		  
	  }
	  
	  
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "This is clients test!";
    }

}
