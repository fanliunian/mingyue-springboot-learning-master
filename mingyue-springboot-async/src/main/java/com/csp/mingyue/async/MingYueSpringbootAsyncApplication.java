package com.csp.mingyue.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/** @author Strive */
@EnableAsync // 开启异步任务
@SpringBootApplication
public class MingYueSpringbootAsyncApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootAsyncApplication.class, args);
  }
}
