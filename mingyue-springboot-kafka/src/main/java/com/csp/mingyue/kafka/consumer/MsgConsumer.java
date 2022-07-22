package com.csp.mingyue.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author Strive
 * @date 2022/4/29 10:38
 */
@Component
@Slf4j
@KafkaListener(
    topics = {"mingyue"},
    groupId = "test-consumer-group")
public class MsgConsumer {

  @KafkaHandler
  public void receive(String message) {
    log.info("消费者接收到的消息是：" + message);
  }
}
