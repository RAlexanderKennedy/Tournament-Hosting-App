package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
}
