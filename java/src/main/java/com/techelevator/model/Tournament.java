package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;

public class Tournament {
	private String name;
	private Date date;
	private Time time;
	private int id;
	//TODO remove?
	//private User[] listOfUsers;
	private int host_id;
	private String status;
	
	public Tournament(String name, Date date, Time time, int id, int host_id, String status) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.id = id;
		this.host_id = host_id;
		this.status = status;
	}


	public Tournament() {
	}


	public int getHost_id() {
		return host_id;
	}


	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}


	public Time getTime() {
		return time;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	};
	
	
	
}

