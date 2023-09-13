package com.project.dasi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class WebConfiguration {
    @Bean
    MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }
}
