package com.vuespringboot.business.post.service;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.form.PostForm.Response.Find;
import com.vuespringboot.business.post.repository.PostQueryRepository;
import com.vuespringboot.business.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    private final JdbcTemplate jdbcTemplate;
    private final int batchSize = 10;


    @Transactional
    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
    }

    public List<Find> findAll(){
        return postQueryRepository.findAllJoinFetch();
//        return postQueryRepository.findAllJoinFetch().stream()
//                             .map(Find::of)
//                             .collect(Collectors.toList());
    }

    public Page<Find> findPageAll(Pageable pageable){
        return postQueryRepository.findPageAllJoinFetch(pageable);
    }
//    public List<Post> findAll(){
//        return postRepository.findAll();
//    }

    public Post findByTitle(String title){
        return postQueryRepository.findByTitle(title);
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
