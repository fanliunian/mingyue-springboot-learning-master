package com.csp.mingyue.filterAndInterceptor.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Ip过滤器
 *
 * @author Strive
 */
@Slf4j
@Component
public class MingYueIpWordFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    log.info("过滤前");
    /*
     * 0:0:0:0:0:0:0:1 是 ipv6 的表现形式，对应 ipv4 来说相当于 127.0.0.1，也就是本机
     * 禁止使用 127.0.0.1 / localhost 访问
     * 这里 ip 可以换成动态黑名单 ip
     */
    if ("0:0:0:0:0:0:0:1".equals(request.getRemoteHost())
        || "127.0.0.1".equals(request.getRemoteHost())) {
      response.getWriter().append("Not Allowed Ip!");
      log.info("Not Allowed Ip：{}!", request.getRemoteHost());
    } else {
      filterChain.doFilter(request, response);
    }
    log.info("过滤后");
  }
}
