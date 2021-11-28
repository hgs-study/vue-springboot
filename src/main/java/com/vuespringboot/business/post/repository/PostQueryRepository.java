package com.vuespringboot.business.post.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vuespringboot.business.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.vuespringboot.business.post.entity.QPost.post;

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
}
