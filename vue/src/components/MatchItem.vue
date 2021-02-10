<template>
  <div class="matchItem">
      <h3>{{match.participant1.displayName}} vs. {{match.participant2.displayName}}</h3>
      <div v-if="match.winner.id == 0">
          <h3>Who Won?</h3>
          <button v-on:click="declareWinner(match.participant1)" class="inviteButton">{{match.participant1.displayName}}</button>
          <button v-on:click="declareWinner(match.participant2)" class="inviteButton">{{match.participant2.displayName}}</button>
      </div>
      <div v-else>
          Winner: {{match.winner.displayName}}
      </div>
      
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
    name: "match-item",
    props: ['match'],
    data() {
        return {

        }
    },
    computed: {
        
    },
    methods: {
        declareWinner(participant) {
            let editedMatch = this.match;
            let par1 = this.match.participant1.id;
            let par2 = this.match.participant2.id;
            let winnerId = participant.id;
            editedMatch.participant1 = {id: par1};
            editedMatch.participant2 = {id: par2};
            editedMatch.winner = {id: winnerId};

            tournamentService.editMatch(editedMatch).then(response => {
                if (response.status != 200 && response.status != 201) {
                    alert("There was an error");
                }
                else {
                    this.$router.go();
                }
            })
            .catch (error => {
            if (error.response) console.log(error.response);
            else if (error.request) console.log(error.request);
            })
        
        },
    }

}

</script>

<style>
.matchItem {

}

</style>