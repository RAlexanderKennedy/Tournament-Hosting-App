<template>
  <div>
  <div id="grid-container">
      

  </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
    name: "brackets",

    props: {
      tournamentId: Number
  },

  data() {
    return {
      participants: [],
      matches:[]
    }
  },
    computed:{
        
        slotUser(){
            let counter = 1;
            const currentDiv = document.getElementById("slot" + counter);
            for(let i = 0; i < this.participants.length; i++){
                //document.getElementById("slot" + counter)
                if(currentDiv.innerText === ""){
                    currentDiv.innerText = this.participants[i].displayName;
                }
                counter++;
            }
            return console.log()
        }
    },
    created(){
        tournamentService.getParticipantsByTournamentId(this.tournamentId)
      .then(response => {
          this.participants = response.data;            

            
            let container = document.getElementById("grid-container");
            for(let i = 0; i < this.participants.length; i++){
             let listItem = document.createElement("div");
             listItem.innerText = this.participants[i].displayName;
             container.appendChild(listItem);
             listItem.setAttribute("class", "card"); 
             listItem.setAttribute("id", ("slot"+ (i+1)));
             listItem.setAttribute("style", "height:35px; vertical-align:middle; padding,10px; background-color:white; border-radius:15px; box-shadow: 4px 3px 8px 1px #969696; -webkit-box-shadow: 4px 3px 8px 1px #969696; padding-top: 15px; min-width:150px;");
             
               
            }
      });

        tournamentService.getMatchesByTournamentId(this.tournamentId)
      .then(response => {
          this.matches = response.data;

      });


    }

}
</script>

<style scoped>
#slot1{
    grid-area:grid1;
}
#slot2{
    grid-area:grid2;
}
#slot3{
    grid-area:grid3;
}
#slot4{
    grid-area:grid4;
}
.slot5{
    grid-area:grid5;
}
#slot6{
    grid-area:grid6;
}
#slot7{
    grid-area:grid7;
}
#slot8{
    grid-area:grid8;
}
#slot9{
    grid-area:grid9;
}
#slot10{
    grid-area:grid10;
}
#slot11{
    grid-area:grid11;
}
#slot12{
    grid-area:grid12;
}
#slot13{
    grid-area:grid13;
}
#slot14{
    grid-area:grid14;
}
#slot15{
    grid-area:grid15;
}
#slot16{
    grid-area:grid16;
}


#grid-container {
    font-size:15px;
    font-weight: bold;
    width:95%;
    overflow-x:auto;
    height:500px;
    padding:20px;
    display: grid;
    grid-gap: 25px 25px;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
    grid-template-areas:
            ". . . . . . . grid1 . . . . . . ."
            ". . . grid2 line9 line10 line11 . line12 line13 line14 grid3 . . ."
            ". grid4 line5 . line6 grid5 . . . grid6 line7 . line8 grid7 ."
            ". line1 . . . line2 . . . line3 . . . line4 ."
            "grid8 . grid9 . grid10 . grid11 . grid12 . grid13 . grid14 . grid15";

        /* "grid1 grid2 grid3 grid4"9
            "grid5 grid6 grid7 grid8"
            "grid9 grid10 grid11 grid12"
            "grid13 grid14 grid15 grid16"; */

    align-items: center;
    text-align: center;
}
/*
.card{
    height:35px;
    vertical-align:middle;
    padding:10px;
    background-color:white;
    border-radius:15px;
    box-shadow: 4px 3px 8px 1px #969696;
-webkit-box-shadow: 4px 3px 8px 1px #969696;
    
}
*/


</style>