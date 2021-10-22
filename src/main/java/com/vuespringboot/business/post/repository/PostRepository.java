package com.vuespringboot.business.post.repository;


import com.vuespringboot.business.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
