<template>
  <div>
    <div class="search">
      <input type="text" placeholder="Search Tournaments" v-model="filter.name">
    </div>
    <ul class="tournaments">
      <li v-for="tournament in filteredList" v-bind:key="tournament.id">
        <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "main-feed",
  data() {
    return {
      filter: {
        name: ""
      },
      tournaments: []
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
      let filteredTournaments = this.tournaments;
      if (this.filter.name != '') {
        filteredTournaments = filteredTournaments.filter((tournament) =>
        tournament.name.toLowerCase()
        .includes(this.filter.name.toLowerCase()));
      }
      return filteredTournaments;
    }
  }

}
</script>

<style>
.search {
  margin:auto;
  max-width:300px
}
.tournaments {
  counter-reset: gradient-counter;
  list-style: none;
  margin: 1.75rem auto;
  padding-left: 1rem;
}
.tournaments li {
    background: white;
    border-radius: 0 0.5rem 0.5rem 0.5rem;
    counter-increment: gradient-counter;
    margin-top: 1rem;
    min-height: 3rem;
    padding: 1rem 1rem 1rem 3rem;
    position: relative;
    max-width:50%;
    
    
    
}


</style>