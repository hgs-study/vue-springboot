package com.vuespringboot.business.post.service;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final JdbcTemplate jdbcTemplate;
    private final int batchSize = 10;


    @Transactional
    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post getById(Long id){
        return postRepository.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }

//    @Transactional
//    public void saveAll(List<Post> posts){
//        int batchCount = 0;
//        List<Post> newPosts = new ArrayList<>();
//        for (int i = 0; i < posts.size(); i++) {
//            newPosts.add(posts.get(i));
//            if ((i + 1) % batchSize == 0) {
//                batchCount = batchInsert(batchSize, batchCount, newPosts);
//            }
//        }
//        if (!newPosts.isEmpty()) {
//            batchCount = batchInsert(batchSize, batchCount, newPosts);
//        }
//        System.out.println("batchCount: " + batchCount);
//    }
//
//    private int batchInsert(int batchSize, int batchCount, List<Post> newPosts) {
//        jdbcTemplate.batchUpdate("INSERT INTO POST (`title`, `content`) VALUES (?, ?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException, SQLException {
//                        ps.setString(1, newPosts.get(i).getTitle());
//                        ps.setString(2, newPosts.get(i).getContent());
//                    }
//                    @Override
//                    public int getBatchSize() {
//                        return newPosts.size();
//                    }
//                });
//        newPosts.clear();
//        batchCount++;
//        return batchCount;
//    }
}
