package com.csp.mingyue.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @author Strive */
@MapperScan("com.csp.mingyue.redis.mapper")
@SpringBootApplication
public class MingYueSpringbootRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootRedisApplication.class, args);
  }
}
