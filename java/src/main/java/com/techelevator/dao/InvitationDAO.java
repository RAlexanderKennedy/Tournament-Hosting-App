package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Invite;

public interface InvitationDAO {
	
	public List<Invite> getAllInvites();
	
	public List<Invite> getInviteByTournamentId(int id);
	
	public List<Invite> getInviteByParticipantId(int id);
	
	public List<Invite> getInviteByHostId(int id);
	
	public void requestJoin();
	
	public void inviteParticipant();
	
	public void acceptInvitation();
	
	public void declineInvitation();

}
