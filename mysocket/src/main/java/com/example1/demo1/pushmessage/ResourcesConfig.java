package com.example1.demo1.pushmessage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/5/24
 * Time: 9:01
 *
 * @author xm
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    public ResourcesConfig() {
    }

    /**
     * 配置资源访问路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/templates/**"}).addResourceLocations(new String[]{"classpath:/templates/"});
        registry.addResourceHandler(new String[]{"/static/**"}).addResourceLocations(new String[]{"classpath:/static/"});
        registry.addResourceHandler(new String[]{"/favicon.ico"}).addResourceLocations(new String[]{"classpath:/static/img/favicon.ico"});
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}