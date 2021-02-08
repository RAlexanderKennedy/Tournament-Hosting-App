<script>
import tournamentService from "@/services/TournamentService.js"
export default {
    name: "my-tournaments",
    data() {
        return {
            filter: {
                user_id: this.$store.state.user.id
            },
            tournaments:[],

            filteredTournaments:[],

            filteredHosted:[],

            isLoading: true
        }
    },
    created() {
        tournamentService.getTournaments().then(response => {
            this.tournaments = response.data;
            let participants = []
            let unfilteredTournaments = this.tournaments;
            unfilteredTournaments.forEach( (tournament) => {
                tournamentService.getParticipantsByTournamentId(tournament.id).then(response => {
                    this.isLoading = false
                    participants = response.data
                    participants.forEach((participant) => {
                        //console.log(participant.id)
                        //console.log(this.filter.user_id)
                        if (participant.id == this.filter.user_id){
                            this.filteredTournaments.push(tournament)
                        //console.log(tournament)
                        //console.log(filteredTournaments)
                    }
                    })
                })
            })
            
            unfilteredTournaments.forEach( (tournament) => {
               
                        if (tournament.host_id == this.filter.user_id){
                            this.filteredHosted.push(tournament)
                        
                    }
                    })
                })
    },
    methods: {
        
    },

    computed: {
       
    }

}
</script>
<template>
<div>
  <h1>My Tournaments</h1>
  <br>
        <div v-if="!this.isLoading">
  <h3> Hosting:</h3>
  <br>
  <ul>
      <li v-for="tournament in this.filteredHosted" v-bind:key="tournament.id">
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
  </ul>
  <h3> Participating:</h3>
  <ul>
      <li v-for="tournament in this.filteredTournaments" v-bind:key="tournament.id">
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
  </ul>
    </div>
</div>
</template>


<style>

</style>