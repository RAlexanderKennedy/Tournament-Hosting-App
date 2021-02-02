<template>
  <div class="home">
    <h1>Home</h1>
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
