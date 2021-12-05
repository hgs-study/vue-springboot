<template>
  <div>
    <h1>UserList</h1>
    <el-table
        :data="findUsers"
        style="width: auto">
      <el-table-column
          prop="id"
          label="번호"
          width="180">
      </el-table-column>
      <el-table-column
          prop="name"
          label="이름"
          width="180">
      </el-table-column>
      <el-table-column
          label="비고"
          width="300">
        <template slot-scope="scope">
          <el-button @click= "removeUser (scope.row)" type= "primary"> 삭제 </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div v-if="userRemoveMessage.length">
      {{userRemoveMessage}}
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name : 'UserList',
  data() {
    return{
      user :{
        name : ''
      }
    }
  },
  created() {
    this.$store.dispatch('FIND_USERS');
  },
  computed : {
    ...mapGetters(['findUsers', 'userRemoveMessage'])
  },
  methods : {
    removeUser(val){
      this.user.name = val.name;
      this.$store.dispatch('REMOVE_USER', this.user);
    },
  }

}
</script>

<style>

</style>