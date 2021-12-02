import axios from 'axios';

const config ={
    baseUrl : 'http://localhost:8080/api/'
}

function registerPost(post){
    return axios.post(`${config.baseUrl}post`, post);
}
function findPosts(page){
    return axios.get(`${config.baseUrl}posts/paging?page=`+(page-1));
}

export {
    registerPost,
    findPosts
}