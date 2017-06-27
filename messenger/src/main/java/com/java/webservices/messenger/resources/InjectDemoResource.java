package com.java.webservices.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("customHeaderValue") String customHeaderValue, @CookieParam("name") String name) {
		return "matrixParam: " + matrixParam + " customHeaderValue:" + customHeaderValue + " name:" + name;
	}

	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers){
		return "path:"+uriInfo.getAbsolutePath().toString()+"headers:"+headers.getCookies().toString();
		 
	}
}
