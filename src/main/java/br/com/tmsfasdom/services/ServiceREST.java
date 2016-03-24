package br.com.tmsfasdom.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;


@Path("ServiceREST")
public class ServiceREST {

	
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		Gson gson = new Gson();
		return gson.toJson("Fernando Lindo");
	}

	
	@GET
	@Path("/somar")
	@Produces(MediaType.APPLICATION_JSON)
	public String somar() {
		Gson gson = new Gson();
		return gson.toJson(5);
	}

}
