import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getTournaments() {
        return http.get('/allTournaments')
    },

    getParticipantsByTournamentId(id) {
        return http.get(`/user/tournament/${id}`);
    },

    getUserById(id) {
        return http.get(`/user/${id}`);
    },

    getTournamentById(id){
        return http.get(`/tournaments/${id}`)
    },

    addDisplayName(username, user) {
        return http.put(`/user/displayName/${username}`, user.displayName)
    },

    getMatchesByTournamentId(id) {
        return http.get(`/tournament/${id}/matches`);
    }


}