package com.learning.teamtracker.resources;

import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ManagedAsync;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import com.learning.teamtracker.dao.EngineerDao;
import com.learning.teamtracker.entities.Engineer;
import com.learning.teamtracker.exceptions.EngineerNotFoundException;

@Path("/engineers")
public class EngineerResource {
	

//------------------------------------------------------
		
	@Context EngineerDao engineerDao;
	
//------------------------------------------------------
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ManagedAsync
	public void getEngineers(@Suspended final AsyncResponse response){
		ListenableFuture<Collection<Engineer>> engineerFuture = engineerDao.getEngineersAsync();
		Futures.addCallback(engineerFuture, new FutureCallback<Collection<Engineer>>() {
			public void onSuccess(Collection<Engineer> engineers){
				response.resume(engineers);
			}
			public void onFailure(Throwable thrown){
				response.resume(thrown);
			}
		});
	}


//------------------------------------------------------
		
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ManagedAsync
	public void getEngineerById(@PathParam("id") String id, @Suspended final AsyncResponse response){
		ListenableFuture<Engineer> engineerFuture = engineerDao.getEngineerAsync(id);
		Futures.addCallback(engineerFuture, new FutureCallback<Engineer>() {
			public void onSuccess(Engineer engineer){
				response.resume(engineer);
			}
			public void onFailure(Throwable thrown){
				response.resume(thrown);
			}
		});
	}
	

//------------------------------------------------------
			
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ManagedAsync
	public void addEngineer(@Valid Engineer engineer, @Suspended final AsyncResponse response){
		
		ListenableFuture<Engineer> engineerFuture = engineerDao.addEngineerAsync(engineer);
		
		Futures.addCallback(engineerFuture, new FutureCallback<Engineer>() {
			public void onSuccess(Engineer addedEngineer){
				response.resume(addedEngineer);
			}
			public void onFailure(Throwable thrown){
				response.resume(thrown);
			}
		});
	}


//------------------------------------------------------
		
}
