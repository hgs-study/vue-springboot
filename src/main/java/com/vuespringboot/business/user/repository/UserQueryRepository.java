package com.vuespringboot.business.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vuespringboot.business.post.entity.Post;

import com.vuespringboot.business.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.vuespringboot.business.post.entity.QPost.post;
import static com.vuespringboot.business.user.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<User> findAllJoinFetch(){
        return jpaQueryFactory
                .selectFrom(user)
                .leftJoin(user.posts,post)
                .fetchJoin()
                .distinct()
                .fetch();
    }
}
