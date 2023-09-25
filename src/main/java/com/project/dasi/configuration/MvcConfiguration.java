package com.project.dasi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");


        // 이미지 불러오기
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("classpath:/upload/");

        registry.addResourceHandler("/savePath/**")
                .addResourceLocations("file:///d:/dasi-project/img/upload/orderImg/");
        registry.addResourceHandler("/imagePath/**")
                .addResourceLocations("file:///d:/dasi-project/img/upload/original/");

    }
}
