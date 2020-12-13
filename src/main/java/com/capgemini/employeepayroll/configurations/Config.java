package com.capgemini.employeepayroll.configurations;

import com.capgemini.employeepayroll.utils.TokenHelper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for third-party beans
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TokenHelper tokenHelper() {
        return new TokenHelper();
    }
}
