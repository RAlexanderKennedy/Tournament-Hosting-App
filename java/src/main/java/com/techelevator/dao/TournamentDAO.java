package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Tournament;

public interface TournamentDAO {
	
	public List<Tournament> getAllTournaments();
	
	public Tournament getTournamentById(int id);
	
	//possibly implement later:
	//public Tournament getTournamentByName(String name);
	
	public void createTournament(Tournament newTournament);
	
	public void editTournament(Tournament tournamentToEdit);
	
	public void deleteTournament(int id);
}
