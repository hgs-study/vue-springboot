import axios from 'axios';

const config ={
    baseUrl : 'http://localhost:3000/api/'
}

function registerPost(post){
    return axios.post(`${config.baseUrl}post`, post);
}
function findPosts(){
    return axios.get(`${config.baseUrl}posts`);
}

export {
    registerPost,
    findPosts
}