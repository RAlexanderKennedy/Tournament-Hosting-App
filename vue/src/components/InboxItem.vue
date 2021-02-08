<template>
  <div>
      <div v-if="invite.sender == 'Participant'">
          {{participantDisplayName}} requested to join 
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <button>Accept</button>
        <button>Decline</button>
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
// import invitationService from "@/services/InvitationService.js"

export default {
    name: "inbox-item",
    props: ['invite'],
    data() {
        return {
            tournamentId: Number,
            tournamentName: "",
            participantDisplayName: "",
            hostDisplayName: ""
        }
    },

    created() {
        tournamentService.getTournamentById(this.invite.tournamentId).
        then(response => {
            let tournament = response.data;
            this.tournamentId = tournament.id;
            this.tournamentName = tournament.name;
        });
        tournamentService.getUserById(this.invite.participantId).
        then(response => {
            let user = response.data;
            this.participantDisplayName = user.displayName
        });
    }
}
</script>

<style>

</style>