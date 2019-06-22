package com.hnsfdx.hslife;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiEndPointsInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("HsLife")
                .description("HsLife")
                .contact(new Contact("胡庆宇&陈宇洋", "None", "None"))
                .version("1.0.0")
                .build();
    }
}
