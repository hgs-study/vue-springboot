package com.vuespringboot.business.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.user.form.UserForm;
import com.vuespringboot.business.user.form.UserForm.Response.Find;
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

    public User(String name) {
        this.name = name;
    }
}
