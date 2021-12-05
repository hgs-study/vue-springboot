export default{
    REGISTER_POST(state,message){
        state.message.post.save = message;
    },
    FIND_POSTS(state,posts){
        state.posts = posts;
    },
    REGISTER_USER(state,message){
        state.users.push(message);
        state.message.user.save = message.name + "가 등록되었습니다.";
    },
    FIND_USERS(state,users){
        state.users = users
    },
    REMOVE_USER(state, message){
        state.message.user.remove = message
    }
} 