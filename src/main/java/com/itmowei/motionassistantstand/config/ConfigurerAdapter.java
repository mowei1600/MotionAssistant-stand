package com.itmowei.motionassistantstand.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MoWei
 * 适配器对所有跨域请求进行放行。
 */
@Configuration
public class ConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(false)
                .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS")
                .allowedOrigins("*")
        ;
    }
}
