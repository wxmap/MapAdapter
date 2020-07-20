package com.gis.MapAdapter.config;

import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
public class Swagger2DevConfig {

    //默认pro环境
    @Profile({"default", "pro"})
    @Bean
    public Docket createWebApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(false).select().build();
    }
    //dev环境接口访问地址:http://localhost:8086/swagger-ui.html
    @Profile("dev")
    @Bean
    public Docket createWebApiDev() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoDev()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
    }
    //测试环境接口访问地址: test.jincou.com/user/swagger-ui.html
    @Profile("test")
    @Bean
    public Docket createWebApiTest() {
        return new Docket(DocumentationType.SWAGGER_2).host("test.jincou.com/user")
                .protocols(Sets.newHashSet("https")).apiInfo(apiInfoDev()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfoDev() {
        return new ApiInfoBuilder().title("地图聚合工具").description(
                "各种地图服务聚合工具").termsOfServiceUrl("http://www.baidu.com").license("TCL").licenseUrl("http://www.baidu.com")
                .contact(new Contact("wxmap","https://github.com/wxmap/wxmap","wxmap@qq.com"))
                .version("2.0").build();
    }
}
