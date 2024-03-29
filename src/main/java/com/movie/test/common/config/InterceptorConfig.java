package com.movie.test.common.config;

import com.movie.test.common.Interceptor.ControllerInterceptor;
import com.movie.test.common.Interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private String[] excludePath = {"/login", "/signup", "/error", "/token/**", "/h2-console", "/h2-console/**"};
    private String[] swagger = {"/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/api-docs/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new ControllerInterceptor())
                .addPathPatterns("/**") // 인터셉터는 **을 사용해야함.
                .order(2)
        ;

//         토큰 인터셉터 -> 개발 편의를 위해 주석.
//        registry.addInterceptor(tokenInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePath)
//                .excludePathPatterns(swagger)
//                .order(1)
//        ;
    }

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }
}
