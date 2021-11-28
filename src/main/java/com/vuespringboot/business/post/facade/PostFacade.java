package com.vuespringboot.business.post.facade;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.form.PostForm;
import com.vuespringboot.business.post.service.PostService;
import com.vuespringboot.business.user.entity.User;
import com.vuespringboot.business.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;
    private final UserService userService;

    public String registerPost(PostForm.Request.Add add){
        final User user = new User(add.getUserName());
        userService.save(user);

        final Post post = new Post(add.getTitle(), add.getContent(), user);
        postService.save(post);
        
        return add.getTitle()+"의 게시글이 등록되었습니다.";
    }

}
