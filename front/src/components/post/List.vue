<template>
  <div id ="app">
      <div v-if="findPosts.length">
        <div v-for="post in findPosts" :key="post.id">
            {{post.id}} ||
            {{post.title}} ||
            {{post.content}}
        </div>
      </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    name : "PostList",
    created(){
        this.$store.dispatch('FIND_POSTS');
    },
    computed : {
        ...mapGetters(['findPosts']),
    },
    // data (){
    //     return {
    //         selected : false,
    //         list : [],
    //         item : null
    //     }
    // },
    // methods : {
    //     fetchData(){
    //         this.$axios.get("/api/posts")
    //         .then(response => {
    //             this.list = response.data;
    //             console.log(response.data);
    //         })
    //         .catch(error => {
    //             console.log(error);
    //         })
    //     }
    // }
            

}
</script>

<style>

</style>