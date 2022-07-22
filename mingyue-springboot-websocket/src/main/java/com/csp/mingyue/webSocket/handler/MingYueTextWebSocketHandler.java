package com.csp.mingyue.webSocket.handler;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocket 服务端
 *
 * @author Strive
 * @date 2022/4/21 16:00
 * @description
 */
@Slf4j
@Component
public class MingYueTextWebSocketHandler extends TextWebSocketHandler {

  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
    log.info("和客户端建立连接");
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    session.close(CloseStatus.SERVER_ERROR);
    log.error("连接异常", exception);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    super.afterConnectionClosed(session, status);
    log.info("和客户端断开连接");
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    // 获取到客户端发送过来的消息
    String receiveMessage = message.getPayload();
    log.info(receiveMessage);
    // 发送消息给客户端
    session.sendMessage(new TextMessage(fakeAi(receiveMessage)));
  }

  private static String fakeAi(String input) {
    if (StrUtil.isBlank(input)) {
      return "你说什么？没听清";
    }

    if ("晚安".equals(input)) {
      return "玛卡巴卡";
    }

    return input;
  }
}
