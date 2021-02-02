<template>
  <div>
    <div v-for="tournament in tournaments" v-bind:key="tournament.id">
      {{tournament.name}}
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