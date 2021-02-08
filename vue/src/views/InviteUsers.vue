<template>
<div>
  <h1>Invite Users To {{tournament.name}}</h1>
    <ul>
        <li v-for="user in users" v-bind:key="user.id">
            {{user.displayName}} <button v-if="!participantIds.includes(user.id)" v-on:click="sendInvite">Invite</button>
        </li>
    </ul>
</div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
import invitationService from "@/services/InvitationService.js"
export default {
    name: "invite-users",
    data() {
        return{

            tournament: [],
            users: [],
            participants: [],
            status: "",
            participantIds: []
        }
    },
    created(){
        tournamentService.getTournamentById(this.$route.params.id).then(response =>{
            this.tournament = response.data;
            this.participants = this.tournament.participants;
            this.status = this.tournament.status
            this.participants.forEach((participant) =>{
                this.participantIds.push(participant.id)
            })
        })

        tournamentService.getAllUsers().then(response =>{
            this.users = response.data;
        })
    },
    computed: {
        canInvite() {
            let bool = true; 
      if (this.tournament.status != "upcoming") {
          bool = false
          }

      return bool;
        }
    },
    methods:{

        sendInvite() {
          let request = {tournamentId:this.tournamentId, participantId: this.$store.state.user.id, sender: "Host"};
          invitationService.sendInvite(request).then(response => {
            if (response.status == 200 || response.status == 201) {
                alert("Request Sent");
                this.$router.go();
              }
              
          })
          .catch(error => {
              console.error(error);
          });
        }
    }
}
</script>

<style>

</style>