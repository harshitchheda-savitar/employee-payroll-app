package com.capgemini.employeepayroll.configurations;

import com.capgemini.employeepayroll.interceptors.JWTRequestInterceptor;
import com.capgemini.employeepayroll.utils.TokenHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for third-party beans
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Configuration
public class Config {

    @Autowired
    private JWTRequestInterceptor jwtRequestInterceptor;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TokenHelper tokenHelper() {
        return new TokenHelper();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(jwtRequestInterceptor).addPathPatterns("/api/v1/employee/**").excludePathPatterns("/api/v1/user/**").pathMatcher(new AntPathMatcher());
            }
        };
    }
}
