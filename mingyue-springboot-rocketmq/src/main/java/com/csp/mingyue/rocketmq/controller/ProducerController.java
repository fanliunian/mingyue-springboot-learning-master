package com.csp.mingyue.rocketmq.controller;

import com.csp.mingyue.rocketmq.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产消息，消费消息
 *
 * @author Strive
 * @date 2022/4/24 17:12
 * @description
 */
@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

  private final ProducerService producerService;

  @GetMapping("/send")
  public String send(String msg) {
    producerService.send(msg);

    return "success";
  }
}
