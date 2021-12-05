package com.vuespringboot.business.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vuespringboot.business.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    @Column(name = "is_active")
    private boolean isActive;

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public void delete(){
        this.isActive = false;
    }
}
