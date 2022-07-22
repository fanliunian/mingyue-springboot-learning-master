package com.csp.mingyue.task.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Strive
 * @date 2022/4/18 16:19
 * @description 明月定时任务
 */
@Slf4j
@Component
public class MingYueScheduledTask {

  /** 每1分钟扫描一次，扫描发送失败的短信，再次发送 */
  @Scheduled(cron = "0 0/1 * * * ?")
  private void sendErrorMsg() {
    log.info("发送失败的短信，再次发送");
  }

  /** 模拟阻塞任务 */
  @Scheduled(cron = "0 0/1 * * * ?")
  private void sendErrorMsg2() throws InterruptedException {
    // 阻塞2分钟
    Thread.sleep(60 * 1000 * 2);
    log.info("222 发送失败的短信，再次发送  222");
  }
}
