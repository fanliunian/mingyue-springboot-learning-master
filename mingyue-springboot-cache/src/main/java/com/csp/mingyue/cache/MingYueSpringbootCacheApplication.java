package com.csp.mingyue.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/** @author Strive */
@MapperScan("com.csp.mingyue.cache.mapper")
@SpringBootApplication
@EnableCaching
public class MingYueSpringbootCacheApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootCacheApplication.class, args);
  }
}
