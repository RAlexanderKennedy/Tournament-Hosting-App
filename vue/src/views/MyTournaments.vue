<template>
<div>
  <h1>My Tournaments</h1>
  <br>
  <h3> Hosting:</h3>
  <br>
  
  <h3> Participating:</h3>
  <ul>
      <li v-for="tournament in filteredList" v-bind:key="tournament.id">
          <router-link class="link-text" v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
  </ul>
</div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
export default {
    name: "my-tournaments",
    data() {
        return {
            filter: {
                user_id: this.$store.state.user.id
            },
            tournaments:[]
        }
    },
    created() {
        tournamentService.getTournaments().then(response => {
            this.tournaments = response.data;
        });
    },
    methods: {

    },

    computed: {
        filteredList() {
            let participants = []
            let unfilteredTournaments = this.tournaments;
            let filteredTournaments = []

            unfilteredTournaments.forEach( (tournament) => {
                participants = tournamentService.getParticipantsByTournamentId(tournament.id)
                if (participants.includes(this.filter.user_id)){
                    filteredTournaments.push(tournament)
                }
            });
            //filteredTournaments = filteredTournaments.filter((tournament) =>
            //participants = tournamentService.getParticipantsByTournamentId(tournament.id),
            //participants.includes(this.filter.user_id)
            //);
            return filteredTournaments
        }
    }

}
</script>

<style>

</style>