package com.learning.teamtracker.dao;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.learning.teamtracker.entities.Engineer;
import com.learning.teamtracker.exceptions.EngineerNotFoundException;

public class EngineerDao {

	private Map<String,Engineer> engineers;
	private ListeningExecutorService service;

	public EngineerDao(){
		engineers = new ConcurrentHashMap<String, Engineer>();
		service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
	}

//------------------------------------------------------
	
	public Collection<Engineer> getEngineers(){
		return engineers.values();
	}
	
	public ListenableFuture<Collection<Engineer>> getEngineersAsync(){

		ListenableFuture<Collection<Engineer>> future = service.submit(new Callable<Collection<Engineer>>() {
			public Collection<Engineer> call() throws Exception {
				return getEngineers();
			}
		});

		return (future);
	}

//------------------------------------------------------

	public Engineer getEngineer(String id) throws EngineerNotFoundException{
		
		if(engineers.containsKey(id))
			return engineers.get(id);
		else
			throw new EngineerNotFoundException("Engineer with ID "+id+" doesn't exist");
	}
	
	public ListenableFuture<Engineer> getEngineerAsync(final String id){

		ListenableFuture<Engineer> future = service.submit(new Callable<Engineer>() {
			public Engineer call() throws Exception {
				return getEngineer(id);
			}
		});

		return (future);
	}
	
//------------------------------------------------------
		
	public Engineer addEngineer(Engineer engineer){
		engineer.setEmpId(UUID.randomUUID().toString());
		engineers.put(engineer.getEmpId(),engineer);
		return engineer;
	}

	
	public ListenableFuture<Engineer> addEngineerAsync(final Engineer engineer){

		ListenableFuture<Engineer> future = service.submit(new Callable<Engineer>() {
			public Engineer call() throws Exception {
				return addEngineer(engineer);
			}
		});

		return (future);
	}

//------------------------------------------------------
			
}
