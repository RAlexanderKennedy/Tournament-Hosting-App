package com.techelevator.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;

@Component
public class TournamentSqlDAO implements TournamentDAO {

	private JdbcTemplate template;
	
	public TournamentSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Autowired
	UserSqlDAO UserDAO;
	
	
	@Override
	public List<User> getUsersByTournamentId(int tournamentId) {
		List<User> participants = new ArrayList<User>();
		String sql = "select * " +
				"from users " +
				"join user_tournament on users.user_id = user_tournament.user_id " +
				"join tournaments on user_tournament.tournament_id = tournaments.tournament_id " +
				"where tournaments.tournament_id = ?";
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
	public List<Match> getMatchesByTournamentId(int tournamentId) {
		List<Match> matches = new ArrayList<Match>();
		String sql = "select * " +
				"from matches " +
				"join tournaments on matches.tournament_id = tournaments.tournament_id " +
				"where tournaments.tournament_id = ?";
		SqlRowSet rs = template.queryForRowSet(sql, tournamentId);
		
		while (rs.next()) {
			Match match = new Match();
			match.setId(rs.getInt("match_id"));
			match.setTournamentId(rs.getInt("tournament_id"));
			match.setRound(rs.getInt("round"));
			
			long par1 = rs.getInt("user1");
			long par2 = rs.getInt("user2");
			Integer winnerId = rs.getInt("winner");
			
			User participant1 = UserDAO.getUserById(par1);
			User participant2 = UserDAO.getUserById(par2);
			match.setParticipant1(participant1);
			match.setParticipant2(participant2);
			
			if (winnerId != null) {
				User winner = UserDAO.getUserById(winnerId.longValue());
				match.setWinner(winner);
			}
			matches.add(match);
			
		}
		
		
		return matches;
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
			Date end_date = result.getDate("end_date");
			Date date = result.getDate("tournament_date");
			List<User> participants = getUsersByTournamentId(id);
			Tournament tournament = new Tournament(name, date, end_date, id, hostId, status, participants);
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
			Date end_date = result.getDate("end_date");
			Date date = result.getDate("tournament_date");
			List<User> participants = getUsersByTournamentId(id);
			Tournament tournament = new Tournament(name, date, end_date, id, hostId, status, participants);
			return tournament;
		}
		return null;
	}

	@Override
	public void createTournament(Tournament newTournament) {
		String name = newTournament.getName();
		String status = newTournament.getStatus();
		int host_id = newTournament.getHost_id();
		Date date = newTournament.getStartDate();
		Date endDate = newTournament.getEndDate();
		int tournamentId = getNextTournamentId();
		String sql = "insert into tournaments (tournament_name, host_id, status, tournament_date, end_date, tournament_id) values (?,?,?,?,?,?)";
		template.update(sql, name, host_id, status, date, endDate, tournamentId);
		for (User user : newTournament.getParticipants()) {
			// TODO: find way to get ID of created tournament
			addParticipant(user.getId(), tournamentId);
		}
	}

	@Override
	public void editTournament(Tournament tournamentToEdit) {
		String sql = "update tournaments set tournament_name = ?, host_id = ?, status = ?, tournament_date = ?, end_date = ? where tournament_id = ?";
		template.update(sql, tournamentToEdit.getName(),tournamentToEdit.getHost_id(), tournamentToEdit.getStatus(), tournamentToEdit.getStartDate(), tournamentToEdit.getEndDate(), tournamentToEdit.getId());
	}

	@Override
	public void deleteTournament(int id) {
		String sql = "DELETE from tournaments WHERE tournament_id = ?";
		template.update(sql, id);

	}


	@Override
	public void addParticipant(long participantId, int tournamentId) {
		String sql = "insert into user_tournament (user_id, tournament_id) values (?,?)";
		template.update(sql, participantId, tournamentId);
		
	}
	
	private int getNextTournamentId() {
		SqlRowSet nextIdResult = template.queryForRowSet("select nextval('seq_tournament_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something has gone horribly, horribly wrong");
		}
	}

	@Override
	public void removeParticipant(long participantId, int tournamentId) {
		String sql = "delete from user_tournament WHERE user_id = ? AND tournament_id = ?";
		template.update(sql, participantId, tournamentId);
		
	}
	

}
