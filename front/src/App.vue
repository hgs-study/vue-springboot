<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
    <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

    <v-spacer></v-spacer>


    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">
            Application
          </v-list-item-title>
          <v-list-item-subtitle>
            subtext
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.to"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({  
        drawer : false,
        items: [
          { title: 'DashBoard', icon: 'mdi-view-dashboard', to : '/dashboard' },
          { title: 'PostInput', icon: 'mdi-view-dashboard', to : '/post/input' },
          { title: 'PostList', icon: 'mdi-image', to : '/post/list' },
          { title: 'userInput', icon: 'mdi-image', to : '/user/input' },
          { title: 'userList', icon: 'mdi-image', to : '/user/list' },
          { title: 'VuetifyPractice', icon: 'mdi-help-box', to :'/vuetify/practice' },
        ],
        right: null,
  }),
};
</script>
