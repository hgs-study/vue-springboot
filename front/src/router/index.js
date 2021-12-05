import Vue from "vue";
import VueRouter from "vue-router";

import DashBoard from '../components/dashboard/dashboard.vue'
import PostInput from 'POST/Input.vue'
import PostList from 'POST/List.vue'
import UserInput from '../components/user/Input.vue'
import UserList from '../components/user/List.vue'
import Practice from '../components/vuetify/Practice.vue'

Vue.use(VueRouter)

export const router = new VueRouter({
    mode : 'history',
    routes : [
        {
            path : '/dashboard',
            component : DashBoard
        },        {
            path : '/post/input',
            component : PostInput
        },
        {
            path : '/post/list',
            component : PostList
        },
        {
            path : '/user/input',
            component : UserInput
        },
        {
            path : '/user/list',
            component : UserList
        },
        {
            path : '/vuetify/practice',
            component : Practice
        }
    ]
})