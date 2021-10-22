<template>
  <div id= "app">
    <layout>
      <div slot="header">
        <h2>Sample</h2>
      </div>

      <div slot ="nav">
        <ul>
           <li>
             <router-link to="/post/input">PostInput</router-link>
           </li>
           <li>
             <router-link to="/post/list">PostList</router-link>
           </li>
        </ul>
      </div>

      <div slot="content">
        <router-view></router-view>
      </div>

      <p slot="footer">Footer !</p>
    </layout>
  </div>
</template>

<script>

import Layout from './components/Layout.vue'

export default {
  components : {Layout}
}
</script>
