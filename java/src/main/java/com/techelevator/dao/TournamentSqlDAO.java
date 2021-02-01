package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Tournament;
import com.techelevator.model.User;

public class TournamentSqlDAO implements TournamentDAO {

	private JdbcTemplate template;
	
	public TournamentSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	//TODO confirm table/column names are correct
	@Override
	public List<Tournament> getAllTournaments() {
		String sql = "select * from tournaments";
		List<Tournament> tournaments = new ArrayList<Tournament>();
		
		SqlRowSet result = template.queryForRowSet(sql);
		
		while (result.next()) {
			String name = result.getString("name");
			int id = result.getInt("id");
			//TODO break users into an array later on 
			//(will need to check how data is displayed on the table)
			String users = result.getString("users");
			String status = result.getString("status");
			//TODO get host data by id and instantiate a user object
			int hostId = result.getInt("host_id");
			//TODO finish instantiating tournament with values from above
			Tournament tournament = new Tournament(id, status);
			tournaments.add(tournament);
		}
		
		return tournaments;
	}

	@Override
	public Tournament getTournamentById(int searchId) {
		String sql = "select * from tournaments where id = ?";
		SqlRowSet result = template.queryForRowSet(sql, searchId);
		
		while (result.next()) {
			String name = result.getString("name");
			int id = result.getInt("id");
			//TODO break users into an array later on 
			//(will need to check how data is displayed on the table)
			String users = result.getString("users");
			String status = result.getString("status");
			//TODO get host data by id and instantiate a user object
			int hostId = result.getInt("host_id");
			//TODO finish instantiating tournament with values from above
			Tournament tournament = new Tournament(id, status);
			return tournament;
		}
		
	}

	@Override
	public void createTournament(Tournament newTournament) {
		String name = newTournament.getName();
		int id = newTournament.getId();
		User[] users = newTournament.getListOfUsers();
		String status = newTournament.getStatus();
		User host = newTournament.getHost();
		
		//TODO check proper order of columns and add to insert statement
		String sql = "insert into tournaments "
	}

	@Override
	public void editTournament(Tournament tournamentToEdit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelTournament(int id) {
		// TODO Auto-generated method stub

	}

}
