package com.example.filter.config;

import com.example.filter.interceptor.OpenAiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private OpenAiInterceptor openAiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(openAiInterceptor)
                .addPathPatterns("/**");

       /* registry.addInterceptor()
                .order()
                order값을 통해 실행 순서 제어 가능
                */
    }
}
