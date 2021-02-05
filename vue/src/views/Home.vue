<template>
  <div class="home">
    <h1 v-if="$store.state.token != ''"> 
      Welcome {{$store.state.user.displayName}}!
    </h1>
    <h2>
      <button>
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
  padding-bottom: 2rem;
}
</style>
