<template>
  <div id ="app">
      <div v-for="item in list" :key="item.id">
          <div>
              {{item.id}}
          </div>
          <div>
              {{item.title}}
          </div>
          <div>
              {{item.content}}
          </div>
      </div>
  </div>
</template>

<script>
export default {
    name : "PostList",
    created(){
        this.fetchData()
    },
    data (){
        return {
            selected : false,
            list : [],
            item : null
        }
    },
    methods : {
        fetchData(){
            this.$axios.get("/api/posts")
            .then(response => {
                this.list = response.data;
                console.log(response.data);
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
            

}
</script>

<style>

</style>