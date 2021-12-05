<template>
    <div>
      <h1>User</h1>
        <div class="title">유저 생성</div>
      이름
        <el-input class="input" placeholder="Please enter userName" v-model="user.name"></el-input>
        <div class="btn-form">
            <el-button
                type="primary"
                @click="registerUser">생성</el-button>
        </div>
        <div v-if="responseMessage.length">{{responseMessage}}</div>
    </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    name : 'UserInput',
    data() { 
        return {
          user : {
            name: ''
          }
        }
    },
    computed : {
      ...mapGetters(['responseMessage'])
    },
    methods : {
      registerUser(){
        this.$store.dispatch('REGISTER_USER',this.user);
      }
    }
}
</script>

<style scoped>
.input {
  width: 180px;
}
.btn-form {
  margin-top: 3%;
  margin-left: 50px;
}
</style>