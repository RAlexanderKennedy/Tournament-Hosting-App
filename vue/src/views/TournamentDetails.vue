<template>
  <div>
      <participants v-bind:tournamentId="parseInt($route.params.id)" />
  </div>
</template>

<script>
import Participants from '../components/Participants.vue'


export default {
  components: { Participants },
    name: "tournament-details"

}
</script>

<style>

</style>