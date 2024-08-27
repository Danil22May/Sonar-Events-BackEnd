package org.factzoopia.sonarEvents.config;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.qos.logback.core.util.Duration;
import lombok.Value;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
    @Value (value = "${api.endpoint}localhost:8080/api/v1/")
    private String baseUrl;

    @Override
    public void addResourceHandlers(ResourceHandlersRegistry registry) {
    
         registry.addResourceHandlers(baseUrl)
                .addResourceLocations("classpath:/static/","classpath:/public/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }
    
}
