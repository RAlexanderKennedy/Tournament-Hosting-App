<template>
  <div>
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
            let round1 = this.matches.filter((match) => {
                if (match.round == 2) return match;
            });

            return round1;
        },
        round3List() {
            let round1 = this.matches.filter((match) => {
                if (match.round == 3) return match;
            });

            return round1;
        },
        round4List() {
            let round1 = this.matches.filter((match) => {
                if (match.round == 4) return match;
            });

            return round1;
        }
    },
    created() {
        tournamentService.getMatchesByTournamentId(parseInt(this.$route.params.id))
        .then(response => {
            this.matches = response.data;
            console.log(this.matches.length);
        })
        
    }

}

// computed match lists by round

// create a method that creates a new match

</script>




<style>

</style>