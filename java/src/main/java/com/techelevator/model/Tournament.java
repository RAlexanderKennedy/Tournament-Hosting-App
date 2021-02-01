package com.techelevator.model;

public class Tournament {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private User[] listOfUsers;
	private User host;
	private String status;
	
	public Tournament(int id, User[] listOfUsers, User host, String status) {
		this.id = id;
		this.listOfUsers = listOfUsers;
		this.host = host;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User[] getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(User[] listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	};
	
	
	
}

