package com.learning.teamtracker.entities;

import java.util.Date;

public class Task {

	private String taskId;
	private String taskHeading;
	private String taskDescription;
	private Date startDate;
	private Date endDate;
	
	public Task(){}
	
	public Task(String taskId, String taskHeading, String taskDescription, Date startDate, Date endDate){
		this.taskId = taskId;
		this.taskHeading = taskHeading;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskHeading() {
		return taskHeading;
	}
	public void setTaskHeading(String taskHeading) {
		this.taskHeading = taskHeading;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
