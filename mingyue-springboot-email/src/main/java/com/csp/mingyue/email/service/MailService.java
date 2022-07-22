package com.csp.mingyue.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮箱处理 Service
 *
 * @author Strive
 * @date 2022/4/27 09:33
 */
@Service
@RequiredArgsConstructor
public class MailService {

  private final JavaMailSender javaMailSender;

  /** 发送方 */
  @Value("${spring.mail.username}")
  private String from;

  /**
   * 发送普通文本邮件
   *
   * @param to 收件人
   * @param subject 主题
   * @param content 内容
   */
  public void sendSimpleMail(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    // 收信人
    message.setTo(to);
    // 主题
    message.setSubject(subject);
    // 内容
    message.setText(content);
    // 发信人
    message.setFrom(from);

    javaMailSender.send(message);
  }
}
