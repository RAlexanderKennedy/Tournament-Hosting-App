<template>
  <div class="controlPanel">
      <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    
    <router-link v-bind:to="{ name: 'tournament-details', params: {id: parseInt($route.params.id)}}">
        <button class="myButton">
            Back to Tournament
        </button>
    </router-link>

      <h2 v-if="round4List.length > 0">Round 4</h2>
      <div v-for="match in round4List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" />
      </div>

      <h2 v-if="round3List.length > 0">Round 3</h2>
      <div v-for="match in round3List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" />
      </div>

      <h2 v-if="round2List.length > 0">Round 2</h2>
      <div v-for="match in round2List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" />
      </div>

      <h2 v-if="round1List.length > 0">Round 1</h2>
      <div v-for="match in round1List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" />
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";
import MatchItem from "@/components/MatchItem.vue";

export default {
    name: "control-panel",
    components: {
        MatchItem
    },
    data() {
        return {
            matches: []
        }
    },
    computed: {
        round1List() {
            let round1 = this.matches.filter((match) => {
                if (match.round == 1) return match;
            });

            return round1;
        },
        round2List() {
            if (this.round1List.length === 0 || !this.roundDone(this.round1List)) return [];
            let round2 = this.matches.filter((match) => {
                if (match.round == 2) return match;
            });

            return round2;
        },
        round3List() {
            if (this.round2List.length === 0 || !this.roundDone(this.round2List)) return [];
            let round3 = this.matches.filter((match) => {
                if (match.round == 3) return match;
            });

            return round3;
        },
        round4List() {
            if (this.round3List.length === 0 || !this.roundDone(this.round3List)) return [];
            let round4 = this.matches.filter((match) => {
                if (match.round == 4) return match;
            });

            return round4;
        }
    },
    created() {
        tournamentService.getMatchesByTournamentId(parseInt(this.$route.params.id))
        .then(response => {
            this.matches = response.data;
            console.log(this.matches.length);
        })
        
    },
    methods: {
        roundDone(roundList) {
            let bool = true;
            roundList.forEach((match) => {
                if (match.winner.id == 0) bool = false; 
            });
            return bool;
        }
    }

}

// computed match lists by round

// create a method that creates a new match

</script>




<style>

.controlPanel{
    font-family: 'Syncopate', sans-serif;
}

</style>