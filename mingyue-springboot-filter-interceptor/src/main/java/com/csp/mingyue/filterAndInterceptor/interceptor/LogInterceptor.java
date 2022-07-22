package com.csp.mingyue.filterAndInterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志拦截器
 *
 * @author Strive
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("拦截前");
    log.info("preHandle request " + request.getServletPath() + " api into");
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    log.info("拦截后");
    log.info("postHandle request " + request.getServletPath() + " api start");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.info("请求与响应完成");
    log.info("afterCompletion request " + request.getServletPath() + " api end");
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
