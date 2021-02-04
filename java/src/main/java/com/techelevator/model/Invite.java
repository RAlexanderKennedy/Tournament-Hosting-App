package com.techelevator.model;

public class Invite {
	private int id;
	private int tournament_id;
	private int participant_id;
	private String sender;
	private String status;
	private boolean read;
	
	
	public Invite() {};
	
	public Invite(int id, int tournament_id, int participant_id, String sender, String status, boolean read) {
		this.id = id;
		this.tournament_id = tournament_id;
		this.participant_id = participant_id;
		this.sender = sender;
		this.status = status;
		this.read = read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public int getParticipant_id() {
		return participant_id;
	}

	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	

}
