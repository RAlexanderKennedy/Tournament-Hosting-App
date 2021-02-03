<template>
  <div id="main-container1">
    <div id="item-wraper">
    <div>
      <input class="search" type="text" placeholder="Search Tournaments" v-model="filter.name">
    </div>
    <ul class="tournaments">
      <li v-for="tournament in filteredList" v-bind:key="tournament.id">
        <router-link class="link-text" v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
      </li>
    </ul>
  </div>
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
#main-container1{
width:100%;  
}

#item-wraper{
width: 600px;
justify-content: center;
padding-left:2%;
margin-left:auto;
margin-right:auto
}

.search {
  margin:auto;
  width:100%;
  min-height:50px;
  border-radius:10px;
  border-width:1px;
  border-color:#ccc;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 2em;
}
.tournaments {
  counter-reset: gradient-counter;
  list-style: none;
  margin: 1.75rem auto;
  padding-left: 0rem;
}
.tournaments li {
    background: white;
    border-radius: 0 0.5rem 0.5rem 0.0rem;
    counter-increment: gradient-counter;
    margin-top: 0rem;
    min-height: 3rem;
    padding: 1rem 1rem 1rem 0rem;
    position: relative;
    max-width:100%;
    border-top: solid darkgray 1px; 
    text-align: center;   
}
  .link-text{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 1.5em;
    color:black;
    text-decoration: none;
    
  } 

  a{
    color:black;
    text-decoration:none;
  }
  a:hover{
    color:#ccc;
  }

  input {
    
    border: 0px solid;
}

input:focus {
    outline: none;
    border-color: #9ecaed;
    box-shadow: 0 0 10px #9ecaed;
}


</style>