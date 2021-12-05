import Vue from 'vue';
import Vuex from 'vuex';
import mutations from './mutations.js';
import actions from './actions.js';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state :{
        post : {
            message : '',
            id : '',
            title : '',
            content : ''
        },
        posts : [],
        list : [],
        message : {},
        users : []
    },
    getters : {
        responseMessage(state){
            return state.message;
        },
        findPosts(state){
            return state.posts;
        },
        findUsers(state){
            return state.users;
        }
    },
    mutations,
    actions,
})