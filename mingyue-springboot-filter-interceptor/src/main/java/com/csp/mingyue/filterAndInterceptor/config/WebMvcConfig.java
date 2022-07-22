package com.csp.mingyue.filterAndInterceptor.config;

import com.csp.mingyue.filterAndInterceptor.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置
 *
 * @author Strive
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 将日志拦截器注册到拦截器注册表
    registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
  }
}
