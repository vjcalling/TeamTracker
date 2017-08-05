package com.learning.teamtracker.entities;

import java.util.ArrayList;
import java.util.List;

public class Engineer {

	//----------------------------------------------------------
	
	private String empId;
	private String name;
	private String email;
	private List<Task> tasks;
	
	//----------------------------------------------------------
	
	public Engineer(){
		tasks = new ArrayList<Task>();
	}
	
	public Engineer(String name, String email){
		tasks = new ArrayList<Task>();
		this.name = name;
		this.email = email;
	}
	
	
	//----------------------------------------------------------

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	//----------------------------------------------------------
}
