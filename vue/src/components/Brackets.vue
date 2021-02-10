<template>
  <div>
  <div id="grid-container">
  <div id=""></div>
  <div id="line1"></div>
  <div id="line2"></div>
  <div id="line3"></div>
  <div id="line4"></div>
  <div id="line5"></div>
  <div id="line6"></div>
  <div id="line7"></div>
  <div id="line8"></div>
  <div id="line9"></div>
  <div id="line10"></div>
  <div id="line11"></div>
  <div id="line12"></div>
  <div id="line13"></div>
  <div id="line14"></div>
  
  
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
      matches:[],
      maxParticipants: Number,
      flip:[]
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

            
            //let container = document.getElementById("grid-container");
            //for(let i = 0; i < this.participants.length; i++){
             //let listItem = document.createElement("div");
             //listItem.innerText = this.participants[i].displayName;
             //container.appendChild(listItem);
             //listItem.setAttribute("class", "card"); 
             //listItem.setAttribute("id", ("slot"+ (i+1)));
             //listItem.setAttribute("style", "height:100%; vertical-align:middle; padding,10px; background-color:white; border-radius:5px;  padding-top: 15px; min-width:150px;" + ("grid-area:grid"+ (i+1) + ";"));
             //listItem.setAttribute("style", ("grid-area:grid"+ (i+1) + ";"))
               
            //}
      });

      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.maxParticipants = response.data.maxParticipants;
      });

        tournamentService.getMatchesByTournamentId(this.tournamentId)
      .then(response => {
          this.matches = response.data;





                                  if(this.maxParticipants === 4){

                        let line5 = document.getElementById("line5")
                        let line6 = document.getElementById("line6")
                        let line7 = document.getElementById("line7")
                        let line8 = document.getElementById("line8")
                        line5.setAttribute("style", "border-width:0px;")
                        line6.setAttribute("style", "border-width:0px;")
                        line7.setAttribute("style", "border-width:0px;")
                        line8.setAttribute("style", "border-width:0px;")
                 

               let container = document.getElementById("grid-container");
               for(let i = 0; i < 3; i++){

                   let setDiv = document.createElement("div");
                   //setDiv.setAttribute("id", ("slot"+ (i+1)));
                   setDiv.innerText = "";
                   let assign = 3 - i
                   setDiv.setAttribute("style", "grid-area:grid"+(assign)+";  height:100%; vertical-align:middle; padding,10px; background-color:white; border-radius:5px;  padding-top: 15px; min-width:150px;");
                   container.appendChild(setDiv);
                   //console.log("I count"+i);

                   let participantA = document.createElement("p");
                   let textA = document.createElement("span");
                   let participantB = document.createElement("p");
                   let textB = document.createElement("span");
                   setDiv.appendChild(participantA);
                   participantA.appendChild(textA);
                   textA.innerText = this.matches[i].participant1.displayName;
                   setDiv.appendChild(participantB);
                   participantB.appendChild(textB);
                   textB.innerText = this.matches[i].participant2.displayName;

                    if(this.matches[i].participant1.displayName !== this.matches[i].winner.displayName){
                        participantA.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textA.setAttribute("style", "color:black;");
                    }else{
                        participantA.setAttribute("style", "color:black");
                        textA.setAttribute("style", "color:black");
                    }

                    if(this.matches[i].participant2.displayName !== this.matches[i].winner.displayName){
                        participantB.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textB.setAttribute("style", "color:black");
                    }else{
                        participantB.setAttribute("style", "color:black");
                        textB.setAttribute("style", "color:black");
                    }

                   
               }
           }



           if(this.maxParticipants === 8){
                 

               let container = document.getElementById("grid-container");
               for(let i = 0; i < 7; i++){

                   let setDiv = document.createElement("div");
                   //setDiv.setAttribute("id", ("slot"+ (i+1)));
                   setDiv.innerText = "";
                   let assign = 7 - i
                   setDiv.setAttribute("style", "grid-area:grid"+(assign)+";  height:100%; vertical-align:middle; padding,10px; background-color:white; border-radius:5px;  padding-top: 15px; min-width:150px;");
                   container.appendChild(setDiv);
                   //console.log("I count"+i);

                   let participantA = document.createElement("p");
                   let textA = document.createElement("span");
                   let participantB = document.createElement("p");
                   let textB = document.createElement("span");
                   setDiv.appendChild(participantA);
                   participantA.appendChild(textA);
                   textA.innerText = this.matches[i].participant1.displayName;
                   setDiv.appendChild(participantB);
                   participantB.appendChild(textB);
                   textB.innerText = this.matches[i].participant2.displayName;

                    if(this.matches[i].participant1.displayName !== this.matches[i].winner.displayName){
                        participantA.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textA.setAttribute("style", "color:black;");
                    }else{
                        participantA.setAttribute("style", "color:black");
                        textA.setAttribute("style", "color:black");
                    }

                    if(this.matches[i].participant2.displayName !== this.matches[i].winner.displayName){
                        participantB.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textB.setAttribute("style", "color:black");
                    }else{
                        participantB.setAttribute("style", "color:black");
                        textB.setAttribute("style", "color:black");
                    }

                   
               }
           }


           if(this.maxParticipants === 16){
                 

               let container = document.getElementById("grid-container");
               for(let i = 0; i < 15; i++){

                   let setDiv = document.createElement("div");
                   //setDiv.setAttribute("id", ("slot"+ (i+1)));
                   setDiv.innerText = "";
                   let assign = 15 - i
                   setDiv.setAttribute("style", "grid-area:grid"+(assign)+";  height:100%; vertical-align:middle; padding,10px; background-color:white; border-radius:5px;  padding-top: 15px; min-width:150px;");
                   container.appendChild(setDiv);
                   //console.log("I count"+i);

                   let participantA = document.createElement("p");
                   let textA = document.createElement("span");
                   let participantB = document.createElement("p");
                   let textB = document.createElement("span");
                   setDiv.appendChild(participantA);
                   participantA.appendChild(textA);
                   textA.innerText = this.matches[i].participant1.displayName;
                   setDiv.appendChild(participantB);
                   participantB.appendChild(textB);
                   textB.innerText = this.matches[i].participant2.displayName;

                    if(this.matches[i].participant1.displayName !== this.matches[i].winner.displayName){
                        participantA.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textA.setAttribute("style", "color:black;");
                    }else{
                        participantA.setAttribute("style", "color:black");
                        textA.setAttribute("style", "color:black");
                    }

                    if(this.matches[i].participant2.displayName !== this.matches[i].winner.displayName){
                        participantB.setAttribute("style", "text-decoration:line-through; color:darkred;");
                        textB.setAttribute("style", "color:black");
                    }else{
                        participantB.setAttribute("style", "color:black");
                        textB.setAttribute("style", "color:black");
                    }

                   
               }
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
#slot5{
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
#line1{
    grid-area:line1;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line2{
    grid-area:line2;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line3{
    grid-area:line3;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line4{
    grid-area:line4;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line5{
    grid-area:line5;
    border-top: black thick solid;
    width:100%;
    min-width: 10px;
    height:100%;
}
#line6{
    border-top: black thick solid;
    grid-area:line6;
    width:100%;
    min-width: 10px;
    height:100%;
}
#line7{
    grid-area:line7;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line8{
    grid-area:line8;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line9{
    grid-area:line9;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line10{
    grid-area:line10;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line11{
    grid-area:line11;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line12{
    grid-area:line12;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line13{
    grid-area:line13;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line14{
    grid-area:line14;
    border-top: black thick solid;
    width:100%;
    min-width: 10px;
    height:100%;
}





#grid-container {
   
    font-size:15px;
    font-weight: bold;
    width:95%;
    overflow-x:auto;
    height:500px;
    padding:20px;
    display: grid;
    grid-gap: 0px 0px;
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