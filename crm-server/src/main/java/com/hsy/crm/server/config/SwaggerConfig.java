package com.hsy.crm.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //说明此类是一个配置类
@EnableSwagger2 //启用swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hsy.crm.server.web"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("CRM接口文档")
                .description("CRM服务对外接口文档(http://localhost:9001/swagger-ui.html)")
                .termsOfServiceUrl("http://localhost:9001")
                .version("1.0")
                .build();
    }
}
