<template>
  <div>
    <div v-if="invite.sender == 'Participant'">
        <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <p>Status: {{invite.status}}</p>
        <button v-on:click="cancel">Cancel Request</button>
    </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
import invitationService from "@/services/InvitationService.js"

export default {
    name: "invitation-item",
    props: ['invite'],
    data() {
        return {
            tournamentId: Number,
            tournamentName: ""
        }
    },

    created() {
        tournamentService.getTournamentById(this.invite.tournamentId).
        then(response => {
            let tournament = response.data;
            this.tournamentId = tournament.id;
            this.tournamentName = tournament.name;
        });
    },
    methods: {
        cancel() {
            let response = confirm("Are you sure you want to cancel this join request?");
            if (response) {
                invitationService.removeInvite(this.invite.id).
                then(response => {
                    if (response.status === 200) {
                        alert("Request Canceled");
                        this.$router.go();
                    }
                    else {
                        alert("Deletion Error");
                    }
                });
            }
        }
    }


}
</script>

<style>

</style>