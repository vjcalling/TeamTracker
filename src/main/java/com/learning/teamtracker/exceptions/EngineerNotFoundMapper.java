package com.learning.teamtracker.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EngineerNotFoundMapper implements ExceptionMapper<EngineerNotFoundException> {

	@Override
	public Response toResponse(EngineerNotFoundException ex) {
		return Response.status(400).entity(ex.getMessage()).type("text/plain").build();
	}
}