package com.vuespringboot.business.post.form;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PostForm {
    public static class Request{
        @Getter
        @Setter
        @NoArgsConstructor
        public static class Add{
            private String title;
            private String content;
            private String userName;

            public Add(String title, String content, String userName) {
                this.title = title;
                this.content = content;
                this.userName = userName;
            }
        }
    }
    public static class Response{
        @Getter
        @NoArgsConstructor
        public static class Find{
            private Long id;
            private String title;
            private String content;
            private String userName;

            public Find(Long id, String title, String content, String userName) {
                this.id = id;
                this.title = title;
                this.content = content;
                this.userName = userName;
            }

            public static Find of(Post post){
                return new Find(post.getId(), post.getTitle(), post.getContent(), post.getUser().getName());
            }
        }
    }
}
