package com.techelevator.model;

public class Tournament {
	private String name;
	private String date;
	private String time;
	private int id;
	//TODO remove?
	//private User[] listOfUsers;
	private int host_id;
	private String status;
	
	public Tournament(String name, String date, String time, int id, int host_id, String status) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
		this.id = id;
		this.host_id = host_id;
		this.status = status;
	}


	public int getHost_id() {
		return host_id;
	}


	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}


	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
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

