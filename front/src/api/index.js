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
function registerUser(user){
    console.log(user)
    return axios.post(`${config.baseUrl}user`,user)
}
function findUsers(){
    return axios.get(`${config.baseUrl}users/fetch`);
}
function removeUser(user){
    return axios.delete(`${config.baseUrl}user`, {data: user});
}

export {
    registerPost,
    findPosts,
    registerUser,
    findUsers,
    removeUser
}