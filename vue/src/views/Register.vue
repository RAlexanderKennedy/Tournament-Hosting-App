<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username: </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="displayName" class="sr-only">Display Name: </label>
      <input
        type="text"
        id="displayName"
        class="form-control"
        placeholder="Display Name"
        v-model="user.displayName"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>

      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';
import tournamentService from '../services/TournamentService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        displayName: '',
        role: 'user',
      },
      users: [],
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      let unique = true
      this.users.forEach(user => {
       if(user.displayName == this.user.displayName){
         
         unique = false
         this.registrationErrors = true
         this.registrationErrorMsg = "This display name is already in use. Please enter another."
         throw new Error
        }
        else if(user.username == this.user.username){
          unique = false
          this.registrationErrorMsg = "This username is already in use. Please enter another."
        }
      });
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      }
      else {
        tournamentService
        .addDisplayName(this.user.username, this.user);
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400 && unique == true) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
  created() {
    tournamentService.getAllUsers().then(response =>{
      this.users = response.data
    })
  }
};
</script>

<style>

</style>
