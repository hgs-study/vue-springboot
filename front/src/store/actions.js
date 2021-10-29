import {findPosts, registerPost} from '../api/index.js';

export default{
    async REGISTER_POST({commit},post){
        const response = await registerPost(post);
        commit('REGISTER_POST',response.data);
        return response;
    },
    async FIND_POSTS({commit}){
        const response = await findPosts();
        commit('FIND_POSTS',response.data);
        return response;
    }
} 