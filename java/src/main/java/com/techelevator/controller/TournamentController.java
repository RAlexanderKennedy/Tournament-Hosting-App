package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.TournamentDAO;
import com.techelevator.model.Tournament;

@RestController
@CrossOrigin
public class TournamentController {
	
	@Autowired
	TournamentDAO tournamentDAO;
	
	@RequestMapping(path="/allTournaments", method=RequestMethod.GET)
	public List<Tournament> getAllTournaments(){
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		return allTournaments;
	};
	
	@RequestMapping(path="/tournaments/{id}", method=RequestMethod.GET)
	public Tournament returnTournamentById(@PathVariable int id) {
		Tournament tournament = tournamentDAO.getTournamentById(id);
		return tournament;
	};
	
	@RequestMapping(path="/editTournament", method=RequestMethod.PUT)
	public void editTournament (@Valid @RequestBody Tournament tournament) {
		tournamentDAO.editTournament(tournament);
	};
	
	@RequestMapping(path="/addTournament", method=RequestMethod.POST)
	public void addTournament (@Valid @RequestBody Tournament tournamentToAdd) {
		tournamentDAO.createTournament(tournamentToAdd);
	};
	
	@RequestMapping(path="/tournament/{id}")
	public void deleteTournament (@PathVariable int id) {
		tournamentDAO.deleteTournament(id);
	};
}
