package com.capgemini.employeepayroll.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger Docket configuration
     *
     * @return Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.capgemini.employeepayroll"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata());
    }

    /**
     * Swagger Metadata Info
     *
     * @return ApiInfo
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("Spring Boot REST API for Employee Payroll System")
                .version("1.0")
                .termsOfServiceUrl("Terms of Service")
                .contact(new Contact("Harshit Chheda", "https://www.linkedin.com/in/harshit-chheda-70b014160", "harshitchheda1998@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}