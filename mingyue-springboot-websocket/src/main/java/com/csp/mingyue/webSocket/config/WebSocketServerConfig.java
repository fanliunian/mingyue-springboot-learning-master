package com.csp.mingyue.webSocket.config;

import com.csp.mingyue.webSocket.handler.MingYueTextWebSocketHandler;
import com.csp.mingyue.webSocket.interceptor.MingYueSocketInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Strive
 * @date 2022/4/21 16:05
 * @description
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketServerConfig implements WebSocketConfigurer {
  private final MingYueTextWebSocketHandler mingYueTextWebSocketHandler;

  private final MingYueSocketInterceptor mingYueSocketInterceptor;

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry
        .addHandler(mingYueTextWebSocketHandler, "/connect")
        .addInterceptors(mingYueSocketInterceptor)
        .withSockJS();
  }
}
