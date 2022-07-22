package com.csp.mingyue.email;

import com.csp.mingyue.email.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试邮件推送
 *
 * @author Strive
 * @date 2022/4/20 10:35
 * @description
 */
@SpringBootTest
public class MailServiceTest {
  @Autowired private MailService mailService;

  @Test
  public void sendSimpleMailTest() {
    mailService.sendSimpleMail("xxx@163.com", "【工具篇】Spring Boot 邮件推送", "Spring Boot 邮件推送 内容 成功喽！");
  }
}
