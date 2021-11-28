<template>
  <div id="app">
      <h1>Post</h1>
      <div class="container">
          <input type="hidden" v-model="post.id">
          <div class="form-group">
              <p>제목</p>
              <input type="text" class="form-control" v-model="post.title">
          </div>
          <div class="form-group">
              <p>이름</p>
              <input type="text" class="form-control" v-model="post.userName">
          </div>
          <div class="form-group">
              <p>내용</p>
              <textarea class="form-control" v-model="post.content" rows="10"></textarea>
          </div>
          <div class="form-group">
              <button @click="registerPost()">저장</button>
              <button @click="$router.back()">돌아가기</button>
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
}
</style>