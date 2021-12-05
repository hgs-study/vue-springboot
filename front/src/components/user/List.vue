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
    </el-table>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name : 'UserList',
  created() {
    this.$store.dispatch('FIND_USERS');
  },
  computed : {
    ...mapGetters(['findUsers'])
  }

}
</script>

<style>

</style>