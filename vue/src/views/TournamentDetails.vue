<template>
  <div>
    <brackets v-bind:tournamentId="parseInt($route.params.id)"/>
      <h3>Host:</h3>
      <host v-bind:hostId="parseInt($route.params.id)" />
      <h3>Participants:</h3>
      <participants v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Status:</h3>
      <status v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Date:</h3>
      <date v-bind:tournamentId="parseInt($route.params.id)" />
      <h3>Time:</h3>
      <tournamentTime v-bind:tournamentId="parseInt($route.params.id)" />
        
      
  </div>
</template>

<script>
import Brackets from '../components/Brackets.vue'
import Participants from '../components/Participants.vue'
import Host from '../components/Host.vue'
import Status from '../components/Status.vue'
import Date from '../components/Date.vue'
import tournamentTime from '../components/Time.vue'
export default {
    
components:{
    Brackets,
    Participants,
    Host,
    Status,
    Date,
    tournamentTime   
},
name: "tournament-details"
}

</script>






<style scoped>
    body{
        background-color:darkgray;
    }
</style>