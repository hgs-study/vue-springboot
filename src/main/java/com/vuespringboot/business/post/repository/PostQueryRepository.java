package com.vuespringboot.business.post.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.form.PostForm;
import com.vuespringboot.business.post.form.PostForm.Response.Find;
import com.vuespringboot.business.user.entity.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.vuespringboot.business.post.entity.QPost.post;
import static com.vuespringboot.business.user.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public Post findByTitle(String title){
        return jpaQueryFactory
                .selectFrom(post)
                .where(post.title.eq(title))
                .fetchOne();
    }

    public List<Find> findAllJoinFetch(){
        return jpaQueryFactory
                .select(Projections.fields(Find.class,
                        post.id.as("id"),
                        post.title.as("title"),
                        post.content.as("content"),
                        user.name.as("userName")
                ))
                .from(post)
                .leftJoin(post.user, user)
                .fetch();
    }
}
