<template>
  <div>
    <div v-for="tournament in tournaments" v-bind:key="tournament.id">
      <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
        {{tournament.name}}
      </router-link>
    </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "main-feed",
  data() {
    return {
      tournaments: []
    }
  },
  created() {
    tournamentService.getTournaments().then(response => {
      this.tournaments = response.data;
    });
  },
  methods: {
    
  }

}
</script>

<style>

</style>