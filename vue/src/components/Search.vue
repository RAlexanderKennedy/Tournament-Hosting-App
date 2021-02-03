<template>
  <div>
      
  </div>
</template>

<script>
export default {
computed:{
  filteredList(){
    let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
  }
}

}
</script>

<style>

</style>