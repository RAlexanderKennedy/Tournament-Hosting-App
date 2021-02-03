<template>
<div>
  {{host.displayName}}
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
export default {
 name: "host",
  props: {
      hostId: Number
  },
  data() {
    return {
      host: ""
    }
  },
  created() {
      tournamentService.getUserById(this.hostId)
      .then(response => {
          this.host = response.data;
      });
  }
}
</script>

<style>

</style>