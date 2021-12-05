<template>
  <div id="app">
      <h1>Post</h1>
      <div class="container">
          <input type="hidden" v-model="post.id">
          <div class="form-group">
              <p>제목</p>
            <el-input class="input" placeholder="Please enter title" v-model="post.title"></el-input>
          </div>
          <div class="form-group">
              <p>이름</p>
             <el-input class="input" placeholder="Please enter title" v-model="post.userName"></el-input>
          </div>
          <div class="form-group">
              <p>내용</p>
            <el-input
                type="textarea"
                :rows="10"
                placeholder="Please input"
                v-model="post.content">
            </el-input>
          </div>
          <div class="form-group">
            <el-button
                type="primary"
                @click="registerPost">저장</el-button>
          </div>
          <span v-if="responseMessage.length">
             {{responseMessage}}
          </span>
      </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    name : "PostInput",
    data() {
        return {
            post : {
                message : '',
                id : '',
                title : '',
                content : '',
                userName : ''
            }
        }
    },
    computed : {
        ...mapGetters(['responseMessage'])
    },
    methods : {
        registerPost(){
            this.$store.dispatch('REGISTER_POST', this.post);
        }
    }
    // methods : {
    //     save : function(){
    //         this.$axios.post('http://localhost:3000/api/post', this.post)
    //         .then(() =>{
    //             this.$router.push('/post')
    //         })
    //         .catch((ex) =>{
    //             console.error("failed write article", ex);
    //         })
    //     }
    // }
}
</script>

<style scoped>
.form-control{
    border : 1px solid;
    width: 80%;
}
</style>