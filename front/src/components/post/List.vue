<template>
  <div id ="app">
      <div v-if="findPosts.content">
        <div v-for="post in findPosts.content" :key="post.id">
            {{post.id}} ||
            {{post.title}} ||
            {{post.content}} ||
            {{post.userName}}
        </div>
      </div>
        <div class="text-center">
        <v-pagination
            v-model="currentPage"
            :length="findPosts.totalPages"
            @page-click="pageClick"
        ></v-pagination>
        </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    name : "PostList",
    data(){
        return {
            currentPage : 1
        }
    },
    watch:{
        findPosts(newMsg) {
            console.log("watch : " + newMsg);
        }
    },
    created(){
        this.$store.dispatch('FIND_POSTS',this.currentPage);
    },
    computed : {
        ...mapGetters(['findPosts']),
    },
	methods: {
			pageClick: function (){
                console.log("test");
                this.$store.dispatch('FIND_POSTS',this.currentPage);
			},
	}
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