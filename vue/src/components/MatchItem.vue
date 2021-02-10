<template>
  <div class="matchItem">
      <h3>{{match.participant1.displayName}} vs. {{match.participant2.displayName}}</h3>
      <div v-if="match.winner.id == 0">
          <h3>Who Won?</h3>
          <button>{{match.participant1.displayName}}</button>
          <button>{{match.participant2.displayName}}</button>
      </div>
      <div v-else>
          Winner: {{match.winner.displayName}}
      </div>
      
  </div>
</template>

<script>
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
        // declareWinner(participant) {
        
        // }
    }

}

</script>

<style>
.matchItem {

}

</style>