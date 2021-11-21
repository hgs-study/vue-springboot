package com.vuespringboot.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST");

//        Credentioals를 true로 주면 모든 Origin을 allow하면 안된다. 특정해야할것
//        maxAge(86400) - 캐시를 주면 preflight 가 요청 보내는 것을 캐싱할 수 있다. 이 설정을 안 하면 요청을 2번 보내기 때문
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("특정 origin")
//                .maxAge(86400)
    }
}
