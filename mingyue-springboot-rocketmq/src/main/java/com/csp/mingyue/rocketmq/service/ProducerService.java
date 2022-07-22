package com.csp.mingyue.rocketmq.service;

import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者
 *
 * @author Strive
 * @date 2022/4/24 17:07
 * @description
 */
@RequiredArgsConstructor
@Service
public class ProducerService {
  private final RocketMQTemplate rocketMQTemplate;

  /**
   * 发送消息
   *
   * @param message 消息体
   */
  public void send(String message) {
    /** 指定发送 mingyue-topic */
    rocketMQTemplate.convertAndSend("mingyue-topic", message);
  }
}
