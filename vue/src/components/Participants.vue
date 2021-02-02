<template>
  <div>
      <div v-for="participant in participants" v-bind:key="participant.id">
          {{participant.displayName}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "participants",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      participants: []
    }
  },
  created() {
      tournamentService.getParticipantsByTournamentId(this.tournamentId)
      .then(response => {
          this.participants = response.data;
      });
  }

}
</script>

<style>

</style>