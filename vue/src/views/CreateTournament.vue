<template>
  <div>
     <h1>
         Create New Tournament
     </h1> 
     <form v-on:submit.prevent="addNewTournament">
         <div class="form-element">
             <label for="name">Tournament Name:</label>
             <input type="text" v-model="newTournament.name" required/>
             </div>
         <div class="form-element">
             <label for="Start Date">Start Date:</label>
             <input type="date" v-model="newTournament.startDate" required/>
             </div>     
         <div class="form-element">
             <label for="End Date">End Date:</label>
             <input type="date" v-model="newTournament.endDate" required/>
             </div>
        <div class="form-element">
             <label for="Maximum Participants">Maximum Participants:</label>
             <input type="text" v-model="newTournament.maxParticipants" required/>
        </div>
             <input type="submit" value="Save" />
             <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
             </form>
  </div>
</template>

<script>
import tournamentService from '../services/TournamentService.js'
export default {
name: "create-tournament",
data() {
    return {
        newTournament: {
            name:'',
            host_id: this.$store.state.user.id,
            startDate:'',
            endDate:'',
            participants: [],
            status: '',
            maxParticipants:''


        }
    }
},
methods: {
    formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
},
    addNewTournament(){
        let currentDate = new Date();
        currentDate = this.formatDate(currentDate)
        if(this.newTournament.startDate < currentDate){
            window.alert('Please enter valid start date')
        }
        else if(this.newTournament.endDate < this.newTournament.startDate){
            window.alert('Please enter valid end date')
        }
        else if(this.newTournament.startDate == currentDate){
            this.newTournament.status = "Ongoing"
            tournamentService.addTournament(this.newTournament).then(
            () => {
                window.alert('Tournament added successfully');
                this.newTournament ={};
                this.$router.push({name: 'home'});
            }
            )
        }
        else {
            this.newTournament.status = "Upcoming"
        tournamentService.addTournament(this.newTournament).then(
            () => {
                window.alert('Tournament added successfully');
                this.newTournament ={};
                this.$router.push({name: 'home'});
            }
        )
        }

    },
    resetForm(){
        this.newTournament = {};
    },
}
}
</script>

<style>
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
</style>