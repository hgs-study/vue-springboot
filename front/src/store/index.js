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
        message : {
            user : {
                save : '',
                remove : '',
                modify : ''
            },
            post : {
                save : '',
                remove : '',
                modify : ''
            }
        },
        users : []
    },
    getters : {
        userSaveMessage(state){
            return state.message.user.save;
        },
        userRemoveMessage(state){
            return state.message.user.remove;
        },
        postSaveMessage(state){
            return state.message.post.save;
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