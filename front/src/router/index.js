import Vue from "vue";
import VueRouter from "vue-router";

import PostInput from 'POST/Input.vue'
import PostList from 'POST/List.vue'
import Practice from '../components/vuetify/Practice.vue'

Vue.use(VueRouter)

export const router = new VueRouter({
    mode : 'history',
    routes : [
        {
            path : '/post/input',
            component : PostInput
        },
        {
            path : '/post/list',
            component : PostList
        },
        {
            path : '/vuetify/practice',
            component : Practice
        }
    ]
})