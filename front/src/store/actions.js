import {findPosts, registerPost, registerUser,findUsers} from '../api/index.js';

export default{
    async REGISTER_POST({commit},post){
        const response = await registerPost(post);
        commit('REGISTER_POST',response.data);
        return response;
    },
    async FIND_POSTS({commit},page){
        console.log("action="+page);
        const response = await findPosts(page);
        commit('FIND_POSTS',response.data);
        return response;
    },
    async REGISTER_USER({commit},user){
        const response = await registerUser(user);
        commit('REGISTER_USER',response.data);
        return response;
    },
    async FIND_USERS({commit}){
        const response = await findUsers();
        commit('FIND_USERS',response.data);
        return response;
    },
} 