<template>
  <div>
  <div id="grid-container">
      <div class="card" id="slot1">1</div>
      <div class="card" id="slot2">2</div>
      <div class="card" id="slot3">3</div>
      <div class="card" id="slot4">4</div>
      <div class="card" id="slot5">5</div>
      <div class="card" id="slot6">6</div>
      <div class="card" id="slot7">7</div>
      <div class="card" id="slot8">8</div>
      <div class="card" id="slot9">9</div>
      <div class="card" id="slot10">10</div>
      <div class="card" id="slot11">11</div>
      <div class="card" id="slot12">12</div>
      <div class="card" id="slot13">13</div>
      <div class="card" id="slot14">14</div>
      <div class="card" id="slot15">15</div>
      <div class="card" id="slot16">16</div>

  </div>
  </div>
</template>

<script>
export default {

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

.card{
    height:35px;
    vertical-align:middle;
    padding:10px;
    background-color:white;
    border-radius:15px;
    box-shadow: 4px 3px 8px 1px #969696;
-webkit-box-shadow: 4px 3px 8px 1px #969696;
    
}



</style>