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
	
	@Override
	public List<Tournament> getAllTournaments() {
		String sql = "select * from tournaments";
		List<Tournament> tournaments = new ArrayList<Tournament>();
		
		SqlRowSet result = template.queryForRowSet(sql);
		
		while (result.next()) {
			String name = result.getString("tournament_name");
			int id = result.getInt("tournament_id");
			//TODO remove?
			//String users = result.getString("users");
			String status = result.getString("status");
			int hostId = result.getInt("host_id");
			String time = result.getString("tournament_time");
			String date = result.getString("tournament_date");
			Tournament tournament = new Tournament(name, time, date, id, hostId, status);
			tournaments.add(tournament);
		}
		
		return tournaments;
	}

	@Override
	public Tournament getTournamentById(int searchId) {
		String sql = "select * from tournaments where tournament_id = ?";
		SqlRowSet result = template.queryForRowSet(sql, searchId);
		
		while (result.next()) {
			String name = result.getString("tournament_name");
			int id = result.getInt("tournament_id");
			//TODO remove?
			//String users = result.getString("users");
			String status = result.getString("status");
			int hostId = result.getInt("host_id");
			String time = result.getString("tournament_time");
			String date = result.getString("tournament_date");
			Tournament tournament = new Tournament(name, time, date, id, hostId, status);
			return tournament;
		}
		return null;
	}

	@Override
	public void createTournament(Tournament newTournament) {
		String name = newTournament.getName();
		String status = newTournament.getStatus();
		int host_id = newTournament.getHost_id();
		String date = newTournament.getDate();
		String time = newTournament.getTime();
		String sql = "insert into tournaments (tournament_name, host_id, status, tournament_date, tournament_time) values (?,?,?,?,?)";
		template.update(sql, name, status, host_id, date, time);
	}

	@Override
	public void editTournament(Tournament tournamentToEdit) {
		String sql = "update tournaments set tournament_name = ?, host_id = ?, status = ?, tournament_date = ?, tournament_time = ? where tournament_id = ?";
		template.update(sql, tournamentToEdit.getName(),tournamentToEdit.getHost_id(), tournamentToEdit.getName(), tournamentToEdit.getStatus(), tournamentToEdit.getDate(), tournamentToEdit.getTime());
	}

	@Override
	public void cancelTournament(int id) {
		String sql = "DELETE from tournaments WHERE tournament_id = ?";
		template.update(sql, id);

	}

}
