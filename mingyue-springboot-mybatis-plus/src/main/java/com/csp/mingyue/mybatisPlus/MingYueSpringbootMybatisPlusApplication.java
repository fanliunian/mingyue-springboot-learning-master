package com.csp.mingyue.mybatisPlus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @author Strive */
@MapperScan("com.csp.mingyue.mybatisPlus.mapper")
@SpringBootApplication
public class MingYueSpringbootMybatisPlusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootMybatisPlusApplication.class, args);
  }
}
