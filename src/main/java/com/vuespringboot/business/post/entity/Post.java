package com.vuespringboot.business.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vuespringboot.business.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void error(){
        throw new IllegalArgumentException("post error");
    }
}
