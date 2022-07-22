package com.csp.mingyue.security.config;

import com.csp.mingyue.security.handler.LoginFailureHandler;
import com.csp.mingyue.security.handler.LoginSuccessHandler;
import com.csp.mingyue.security.service.MingYueUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Security 配置
 *
 * @author Strive
 * @date 2022/4/22 15:11
 * @description
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final MingYueUserDetailsService mingYueUserDetailsService;

  /** 登录成功的处理 */
  private final LoginSuccessHandler loginSuccessHandler;
  /** 登录失败的处理 */
  private final LoginFailureHandler loginFailureHandler;

  /** 配置认证方式等 */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(mingYueUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  /** http相关的配置，包括登入登出、异常处理、会话管理等 */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable();
    http.authorizeRequests()
        // 放行接口
        // .antMatchers().permitAll()
        // 除上面外的所有请求全部需要鉴权认证
        .anyRequest()
        .authenticated()
        // 登入
        .and()
        .formLogin()
        // 允许所有用户
        .permitAll()
        // 登录成功处理逻辑
        .successHandler(loginSuccessHandler)
        // 登录失败处理逻辑
        .failureHandler(loginFailureHandler);
  }
}
