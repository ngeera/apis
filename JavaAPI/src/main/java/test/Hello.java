package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello()
	{
		String resource = "<? xml version='1.0' ?>" + 
	                       "<hello> Hi Dennis, this is Hello from XML </hello>";
		return null;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJASON()
	{
		String resource = "<h1> Hi Dennis, this is Hello from HTML </h1>";
		return null;
		
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML()
	{
		String resource = null;
		return null;
		
	}
	
	

}
