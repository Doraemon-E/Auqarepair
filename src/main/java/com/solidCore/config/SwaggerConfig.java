package com.solidCore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @projectName: AquaRepair
 * @package: com.solidCore.config
 * @className: SwaggerConfig
 * @author: tongsheng
 * @description: TODO
 * @date: 2023/3/12 19:05
 * @version: 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.solidCore.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文档说明
                .title("AquaRepair")
                //文档版本说明
                .version("1.0.0")
                .build();
    }
}
