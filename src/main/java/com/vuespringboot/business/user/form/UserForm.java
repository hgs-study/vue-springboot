package com.vuespringboot.business.user.form;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserForm {
    public static class Response{
        @Getter
        @NoArgsConstructor
        public static class Find{
            private Long id;
            private String name;
            private List<Post> posts;

            public Find(Long id, String name, List<Post> posts) {
                this.id = id;
                this.name = name;
                this.posts = posts;
            }

            public static Find of(User user){
                return new Find(user.getId(), user.getName(), user.getPosts());
            }
        }
    }
}
