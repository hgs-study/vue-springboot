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
              <p>내용</p>
              <textarea class="form-control" v-model="post.content" rows="10"></textarea>
          </div>
          <div class="form-group">
              <button @click="save">저장</button>
              <button @click="$router.back()">돌아가기</button>
          </div>

      </div>
  </div>
</template>

<script>
export default {
    name : "PostInput",
    data() {
        return {
            post : {
                message : '',
                id : '',
                title : '',
                content : ''
            }
        }
    },
    methods : {
        save : function(){
            this.$axios.post('http://localhost:3000/api/post', this.post)
            .then(() =>{
                this.$router.push('/post')
            })
            .catch((ex) =>{
                console.error("failed write article", ex);
            })
        }
    }
}
</script>

<style>

</style>