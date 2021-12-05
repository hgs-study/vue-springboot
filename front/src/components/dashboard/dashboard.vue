<template>
  <div>
    <div class="user group">
      <user-input class="left_content"></user-input>
      <user-list class="right_content"></user-list>
    </div>
    <el-divider></el-divider>
    <div class="post group">
      <post-input class="left_content"></post-input>
      <post-list class="right_content"></post-list>
    </div>
  </div>
</template>

<script>
import PostInput from "POST/Input";
import PostList from "POST/List";
import UserInput from "@/components/user/Input";
import UserList from "@/components/user/List";

export default {
  components: {UserList, UserInput, PostList, PostInput}
}
</script>

<style scoped>
.group {
  display: flex;
}
.left_content{
  width: 30%;
}
</style>