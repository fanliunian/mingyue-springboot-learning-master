package com.csp.mingyue.xxjob.scheduled;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
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
  @XxlJob("sendErrorMsg")
  public ReturnT<String> sendErrorMsg() {
    log.info("发送失败的短信，再次发送");

    return ReturnT.SUCCESS;
  }
}
