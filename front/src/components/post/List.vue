<template>
  <div id ="app">
      <div v-if="findPosts.content">
        <div v-for="post in findPosts.content" :key="post.id">
            {{post.id}} ||
            {{post.title}} ||
            {{post.content}} ||
            {{post.userName}}
        </div>
      </div>ddssddddddasdasd
        <div class="text-center">
        <v-pagination
            v-model="currentPage"
            :length="findPosts.totalPages"
            @page-click="pageClick"
        ></v-pagination>

          <el-pagination
              background
              layout="prev, pager, next"
              :total="findPosts.totalElements"
              :page-size="findPosts.size"
              @current-change="pageClick">
          </el-pagination>
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
    created(){
        this.$store.dispatch('FIND_POSTS',this.currentPage);
    },
    computed : {
        ...mapGetters(['findPosts']),
    },
	methods: {
			pageClick: function (val){
        this.$store.dispatch('FIND_POSTS',val);
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