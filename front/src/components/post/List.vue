<template>
  <div id ="app">
    <h1>Post List</h1>
    <el-table
        :data="findPosts.content"
        style="width: auto">
      <el-table-column
          prop="id"
          label="번호"
          width="180">
      </el-table-column>
      <el-table-column
          prop="title"
          label="제목"
          width="180">
      </el-table-column>
      <el-table-column
          prop="content"
          label="내용"
          width="180">
      </el-table-column>
      <el-table-column
          prop="userName"
          label="이름"
          width="180">
      </el-table-column>
    </el-table>
        <div class="text-center">
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