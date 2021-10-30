package com.vuespringboot.common.config;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private static final int chunkSize = 10;

    @Bean
    public Job postJob(){
        return jobBuilderFactory.get("postJob")
                                .start(postStep())
                                .build();
    }

    @Bean
    public Step postStep(){
        return stepBuilderFactory.get("postStep")
                                 .<Post,Post> chunk(chunkSize)
                                 .reader(postReader())
                                 .processor(postProcessor())
                                 .writer(postWriter())
                                 .build();
    }

    @Bean
    public JpaPagingItemReader<Post> postReader(){
        return new JpaPagingItemReaderBuilder<Post>()
                    .name("postReader")
                    .entityManagerFactory(entityManagerFactory)
                    .pageSize(chunkSize)
                    .queryString("select a from Post a")
                    .build();
    }

    @Bean
    public ItemProcessor<Post,Post> postProcessor(){
        return Post -> {
            Post.update(Post.getId(), Post.getTitle()+"@", Post.getContent());
            return Post;
        };
    }

    @Bean
    public ItemWriter<Post> postWriter(){
        return Posts ->{
            Posts.stream()
                 .forEach(T -> System.out.println("T.getTitle() = " + T.getTitle() +"/"+ T.getContent()));
        };
    }

}
