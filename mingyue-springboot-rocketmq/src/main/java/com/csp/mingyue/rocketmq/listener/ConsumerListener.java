package com.csp.mingyue.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author Strive
 */
@Slf4j
@RocketMQMessageListener(topic = "mingyue-topic", consumerGroup = "mingyue-consumer-group")
@Component
public class ConsumerListener implements RocketMQListener<String> {

  @Override
  public void onMessage(String s) {
    log.info("接受到【mingyue-topic】信息：{}", s);
  }
}
