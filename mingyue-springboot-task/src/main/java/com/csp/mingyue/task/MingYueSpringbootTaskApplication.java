package com.csp.mingyue.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/** @author Strive */
@EnableScheduling
@SpringBootApplication
public class MingYueSpringbootTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(MingYueSpringbootTaskApplication.class, args);
  }
}
