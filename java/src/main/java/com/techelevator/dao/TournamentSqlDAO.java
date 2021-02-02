package com.techelevator.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Tournament;
import com.techelevator.model.User;

@Component
public class TournamentSqlDAO implements TournamentDAO {

	private JdbcTemplate template;
	
	public TournamentSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	
	@Override
	public List<User> getUsersByTournamentId(int tournamentId) {
		List<User> participants = new ArrayList<User>();
		String sql = "select * " +
				"from users " +
				"join user_tournament on user.user_id = user_tournament.user_id " +
				"join tournaments on user_tournament.tournament_id = tournament.tournament_id " +
				"where tournament.tournament_id = ?";
		SqlRowSet rs = template.queryForRowSet(sql, tournamentId);
		
		while (rs.next()) {
			User user = new User();
	        user.setId(rs.getLong("user_id"));
	        user.setUsername(rs.getString("username"));
	        user.setPassword(rs.getString("password_hash"));
	        user.setAuthorities(rs.getString("role"));
	        user.setActivated(true);
	        user.setDisplayName(rs.getString("display_name"));
	        participants.add(user);
		}
		
		return participants;
	}
	
	@Override
	public List<Tournament> getAllTournaments() {
		String sql = "select * from tournaments";
		List<Tournament> tournaments = new ArrayList<Tournament>();
		
		SqlRowSet result = template.queryForRowSet(sql);
		
		while (result.next()) {
			String name = result.getString("tournament_name");
			int id = result.getInt("tournament_id");
			String status = result.getString("status");
			int hostId = result.getInt("host_id");
			Time time = result.getTime("tournament_time");
			Date date = result.getDate("tournament_date");
			List<User> participants = getUsersByTournamentId(id);
			Tournament tournament = new Tournament(name, date, time, id, hostId, status, participants);
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
			String status = result.getString("status");
			int hostId = result.getInt("host_id");
			Time time = result.getTime("tournament_time");
			Date date = result.getDate("tournament_date");
			List<User> participants = getUsersByTournamentId(id);
			Tournament tournament = new Tournament(name, date, time, id, hostId, status, participants);
			return tournament;
		}
		return null;
	}

	@Override
	public void createTournament(Tournament newTournament) {
		String name = newTournament.getName();
		String status = newTournament.getStatus();
		int host_id = newTournament.getHost_id();
		Date date = newTournament.getDate();
		Time time = newTournament.getTime();
		String sql = "insert into tournaments (tournament_name, host_id, status, tournament_date, tournament_time) values (?,?,?,?,?)";
		template.update(sql, name, host_id, status, date, time);
		for (User user : newTournament.getParticipants()) {
			// TODO: find way to get ID of created tournament
			// addParticipant(user.getId(), tournamentId);
		}
	}

	@Override
	public void editTournament(Tournament tournamentToEdit) {
		String sql = "update tournaments set tournament_name = ?, host_id = ?, status = ?, tournament_date = ?, tournament_time = ? where tournament_id = ?";
		template.update(sql, tournamentToEdit.getName(),tournamentToEdit.getHost_id(), tournamentToEdit.getStatus(), tournamentToEdit.getDate(), tournamentToEdit.getTime(), tournamentToEdit.getId());
	}

	@Override
	public void deleteTournament(int id) {
		String sql = "DELETE from tournaments WHERE tournament_id = ?";
		template.update(sql, id);

	}


	@Override
	public void addParticipant(int participantId, int tournamentId) {
		String sql = "insert into user_tournament (user_id, tournament_id) values (?,?)";
		template.update(sql, participantId, tournamentId);
		
	}

	

}
