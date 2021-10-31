package com.vuespringboot.business.post.api;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.service.PostService;
import com.vuespringboot.common.config.BatchConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final BatchConfig batchConfig;
    private final JobLauncher jobLauncher;

    @PostMapping("/post")
    public String register(@RequestBody Post post){
        Post savedPost = postService.save(post);
        return savedPost.getTitle() + "의 글이 포스팅되었습니다.";
    }

    @GetMapping("/post/{id}")
    public Post getById(@PathVariable Long id){
        return postService.getById(id);
    }

    @GetMapping("/posts")
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/batchTest")
    public void batchTest() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobLauncher.run(
                batchConfig.postJob(),
                new JobParametersBuilder()
                        .addString("job.name","postJob")
                        .addString("version", LocalDateTime.now().toString())
                        .toJobParameters()
        );
    }
}
