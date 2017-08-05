package com.learning.teamtracker.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EngineerNotFoundException extends Exception implements ExceptionMapper<EngineerNotFoundException> {

	public EngineerNotFoundException(String s) {
		super(s);
	}
	
	public Response toResponse(EngineerNotFoundException ex){
		return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
	}
}
