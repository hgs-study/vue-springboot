export default{
    REGISTER_POST(state,message){
        state.message = message;
    },
    FIND_POSTS(state,posts){
        state.posts = posts;
    }
} 