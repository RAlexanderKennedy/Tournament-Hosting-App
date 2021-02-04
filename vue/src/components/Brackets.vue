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
      testPlayers:[
          {
            name:"player1",
            round: 1,
            eleminated: false,
            win: false,
          },
          {
            name:"player2",
            round: 1,
            eleminated: false,
            win: false,
          },
          {
            name:"player3",
            round: 1,
            eleminated: false,
            win: false,
          },
          {
            name:"player4",
            round: 1,
            eleminated: false,
            win: false,
          },
      ]
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
             listItem.setAttribute("style", "height:35px; vertical-align:middle; padding,10px; background-color:white; border-radius:15px; box-shadow: 4px 3px 8px 1px #969696; -webkit-box-shadow: 4px 3px 8px 1px #969696; padding-top: 15px;");
             
               
            }
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
    height:800px;
    padding:20px;
    display: grid;
    grid-gap: 20px 50px;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr 1fr;
    grid-template-areas:
            "grid1 grid2 grid3 grid4"
            "grid5 grid6 grid7 grid8"
            "grid9 grid10 grid11 grid12"
            "grid13 grid14 grid15 grid16";
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