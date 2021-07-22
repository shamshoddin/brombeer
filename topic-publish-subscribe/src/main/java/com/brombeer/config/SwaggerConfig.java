package com.brombeer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Optional;

//import org.springframework.ws.config.annotation.EnableWs;


@Configuration
@EnableSwagger2
//@EnableWs
public class SwaggerConfig {

    @Bean
    public Docket apis(ConfigurableEnvironment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(environment.getProperty("config.host"))
                .groupName(environment.getProperty("spring.application.name"))
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .genericModelSubstitutes(Optional.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.brombeer.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "PPMS  Microservice APIs Documentation",
                        "PPMS Microservice APIs Documentation",
                        "1.0.0", "https://developer.brombeer.com/api-catalogue",
                        new Contact("brombeer", "http://www.brombeer.com",
                                "CMTF@brombeer.com"),
                        "brombeer API license 1.0",
                        "https://developer.brombeer.com/api-catalogue", Collections.emptyList()));
    }
   /* @Bean
    public SwaggerJacksonModuleRegistrar swaggerJacksonModuleRegistrar() {
        return new SwaggerJacksonModuleRegistrar();
    }*/

    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .operationsSorter(OperationsSorter.METHOD)
                .build();
    }

}
