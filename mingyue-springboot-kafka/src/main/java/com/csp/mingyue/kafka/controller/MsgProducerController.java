package com.csp.mingyue.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者
 *
 * @author Strive
 * @date 2022/4/29 10:39
 */
@RestController
public class MsgProducerController {

  @Autowired private KafkaTemplate kafkaTemplate;

  @RequestMapping("/send")
  public void send(String message) {
    kafkaTemplate.send("mingyue", message);
  }
}
