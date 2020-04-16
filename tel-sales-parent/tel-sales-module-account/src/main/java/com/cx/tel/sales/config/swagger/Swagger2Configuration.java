package com.cx.tel.sales.config.swagger;

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

@Configuration  
@EnableSwagger2
public class Swagger2Configuration {
	
	String basePackage = "com.cx.tel.sales.api";
	String title = "电销企业账户管理";
	String description = "电销用户企业用户管理描述";
	String version = "1.0";
	String apiUrl = "http://localhost:8070/"; //请求服务index
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(new Contact("badboyren@163.com", "https://www.mfhcd.com", "2416828825@qq.com"))
                        .license("这是网站使用的协议...")
                        .licenseUrl(apiUrl)
                        .build());
    }
	
	 // 配置swagger2核心配置 docket
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
////        		.groupName(groupName)
//                    .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
//                    .select()
//                    .apis(RequestHandlerSelectors
//                            .basePackage(basePackage))   // 指定controller包
//                    .paths(PathSelectors.any())         // 所有controller
////                    .paths(regex("/v3/api/.*"))// 拦截的接口路径
//                    .build();
//    }
// 
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(title)
//                .description(description)
//                .termsOfServiceUrl(apiUrl)
//                .version(version)
//                .build();
//    }
}
