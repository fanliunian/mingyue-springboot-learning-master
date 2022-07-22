package com.csp.mingyue.swagger.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 *
 * @author : Strive
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  /** 配置 Swagger 2 注册一个 Bean 属性 enable()：是否启用 Swagger，启用后才能在浏览器中进行访问 groupName()：用于配置 API 文档的分组 */
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .enable(true)
        .groupName("v2")
        .select()
        // 过滤路径
        .paths(PathSelectors.any())
        // 指定扫描的包
        .apis(RequestHandlerSelectors.basePackage("com.csp.mingyue.swagger.controller"))
        .build();
  }

  private ApiInfo apiInfo() {
    /*作者信息*/
    Contact contact =
        new Contact(
            "Strive", "https://gitee.com/csps/mingyue-springboot-learning", "732171109@qq.com");
    return new ApiInfo(
        "Swagger 测试接口文档",
        "【接口篇】SpringBoot 整合 Swagger2 实现在线 API 文档",
        "v2.0",
        "https://gitee.com/csps/mingyue-springboot-learning",
        contact,
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        new ArrayList());
  }
}
