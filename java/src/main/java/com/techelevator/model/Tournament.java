package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private String name;
	private Date startDate;
	private Date endDate;
	private int id;
	private List<User> participants = new ArrayList<User>();
	private int host_id;
	private String status;
	
	public Tournament(String name, Date startDate, Date endDate, int id, int host_id, String status, List<User> participants) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.id = id;
		this.host_id = host_id;
		this.status = status;
		this.participants = participants;
	}

	public List<User> getParticipants() {
		return participants;
	}
	
	
	public void setListOfUsers(List<User> participants) {
		this.participants = participants;
	}

	public Tournament() {
	}


	public int getHost_id() {
		return host_id;
	}


	public void setHost_id(int host_id) {
		this.host_id = host_id;
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

