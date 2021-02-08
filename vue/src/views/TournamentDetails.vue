<template>
  <div>
    <brackets v-bind:tournamentId="parseInt($route.params.id)"/>
      <h3>Host:</h3>
      <host v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Participants:</h3>
      <participants v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Status:</h3>
      <status v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Start Date:</h3>
      <date v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>End Date:</h3>
      <endDate v-bind:tournamentId="parseInt($route.params.id)" />
      <br>
      <button 
      v-if="canJoin" 
      :disabled='requested == "Join Requested" || requested == "Join Declined"'
      v-on:click="sendInvite">
        {{requested}}
      </button>
      <button v-if="canLeave"
      v-on:click="leaveTournament">
        Leave Tournament
      </button>
        
      
  </div>
</template>

<script>
import Brackets from '../components/Brackets.vue'
import Participants from '../components/Participants.vue'
import Host from '../components/Host.vue'
import Status from '../components/Status.vue'
import Date from '../components/Date.vue'
import endDate from '../components/EndDate.vue'
import invitationService from '../services/InvitationService'
import tournamentService from "@/services/TournamentService.js";

export default {
    
  components:{
      Brackets,
      Participants,
      Host,
      Status,
      Date,
      endDate   
  },
  name: "tournament-details",
  data() {
    return {
      buttonText: 'Join Tournament',
      invites: [],
      participants: [],
      status: "",
      tournamentId: Number
    }
  },
  computed: {
    canJoin() {
      let bool = true; 
      if (this.status != "Upcoming") bool = false;
      this.participants.forEach( (participant) => {
        if (participant.id === this.$store.state.user.id) {
          console.log(participant.id);
          bool = false;
        }
      });
      return bool;
    },
    canLeave() {
      let bool = false; 
      if (this.status == "Upcoming") {
        this.participants.forEach( (participant) => {
        if (participant.id === this.$store.state.user.id) {
          console.log(participant.id);
          bool = true;
        }
        });
      }
      return bool;
    },
    requested() {
      let text = "Join Tournament";
      this.invites.forEach( (invite) => {
        if (invite.participantId === this.$store.state.user.id) {
          if (invite.status === "Pending") {
            text =  "Join Requested"
          }
          else if (invite.status === "Declined") {
            text =  "Join Declined"
          }
        }
      });
      return text;
    }
  },
  created() {
    if (this.joined) {
      this.buttonText = 'Join Requested';
    }

    invitationService.getInvitesByTournamentId(parseInt(this.$route.params.id)).then(
      response => {
        this.invites = response.data;
      }
    );

    tournamentService.getTournamentById(parseInt(this.$route.params.id))
      .then(response => {
          let tournament = response.data;
          this.status = tournament.status;
          this.participants = tournament.participants;
          this.tournamentId = tournament.id;
      });

  },
  methods: {
    sendInvite() {
      let request = {tournamentId:this.tournamentId, participantId: this.$store.state.user.id, sender: "Participant"};
      invitationService.sendInvite(request).then(response => {
        if (response.status == 200 || response.status == 201) {
            alert("Request Sent");
            this.$router.go();
          }
          
      })
      .catch(error => {
          console.error(error);
      });
    },
    leaveTournament() {
      let re = confirm("Are you sure you want to leave this tournament?");
      if (re) {
        tournamentService.removeParticipant(this.$store.state.user.id, this.tournamentId).
        then(response => {
          if (response.status === 200) {
            alert("You have left this tournament");
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






<style scoped>
    body{
        background-color:darkgray;
    }
</style>