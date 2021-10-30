package com.vuespringboot.business.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

//    @Column(name = "is_batch_processor")
//    private boolean isBatchProcessor;

//    public Post update(Post post){
//        return new Post(post.getId(),post.getTitle(),post.getContent(), post.isBatchProcessor());
//    }
    public void update(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
//        this.isBatchProcessor = isBatchProcessor;
    }
}
