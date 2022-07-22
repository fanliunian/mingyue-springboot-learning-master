package com.csp.mingyue.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MingYueSpringbootEventApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootEventApplication.class, args);
  }
}
