<template>
  <div class="home">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    <h1 v-if="$store.state.token != ''"> 
      Welcome, {{$store.state.user.displayName}}!
    </h1>
    <h2>
      <button v-if="$store.state.token != ''" class="myButton">
        <router-link v-bind:to="{ name: 'create-tournament'}">Create New Tournament</router-link>
      </button>
    </h2>
    <h1 v-if="$store.state.token == ''"> 
      Welcome!
    </h1>
    <MainFeed />
  </div>
</template>

<script>
import MainFeed from "@/components/MainFeed";

export default {
  name: "home",
  components: {
    MainFeed
  }
};
</script>

<style>
.home {
  text-align: center;
}
.home h1 {
  padding-top: 1rem;
  padding-bottom: 1.5rem;
font-family: 'Syncopate', sans-serif;
}

.myButton {
	box-shadow: 3px 4px 0px 0px #899599;
	background:linear-gradient(to bottom, #ededed 5%, #bab1ba 100%);
	background-color:#ededed;
	border-radius:15px;
	border:1px solid #d6bcd6;
	display:inline-block;
	cursor:pointer;
	color:#3a8a9e;
	font-family:Arial;
	font-size:17px;
	padding:7px 25px;
	text-decoration:none;
	text-shadow:0px 1px 0px #e1e2ed;
}
.myButton:hover {
	background:linear-gradient(to bottom, #bab1ba 5%, #ededed 100%);
	background-color:#bab1ba;
}
.myButton:active {
	position:relative;
	top:1px;
}


</style>
