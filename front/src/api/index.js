import axios from 'axios';

const config ={
    baseUrl : 'http://localhost:3000/api/'
}

function registerPost(post){
    return axios.post(`${config.baseUrl}post`, post);
}

export {
    registerPost,
}