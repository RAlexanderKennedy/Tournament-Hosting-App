<template>
  <div>
    <brackets/>
      
      <participants v-bind:tournamentId="parseInt($route.params.id)" />
        
      
  </div>
</template>

<script>
import Brackets from '../components/Brackets.vue'
import Participants from '../components/Participants.vue'
export default {
    
components:{
    Brackets,
    Participants   
},
name: "tournament-details"
}

</script>






<style scoped>
    body{
        background-color:darkgray;
    }
</style>