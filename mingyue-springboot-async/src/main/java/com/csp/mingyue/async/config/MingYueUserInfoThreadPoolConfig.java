package com.csp.mingyue.async.config;

import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池配置
 *
 * @author Strive
 */
@Slf4j
@Configuration
public class MingYueUserInfoThreadPoolConfig {

  @Bean(name = "userInfoThreadPoolExecutor")
  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
    log.info("---------- 线程池开始加载 ----------");
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    // 核心线程池大小
    threadPoolTaskExecutor.setCorePoolSize(15);
    // 最大线程数
    threadPoolTaskExecutor.setMaxPoolSize(30);
    // 队列容量
    threadPoolTaskExecutor.setQueueCapacity(15);
    // 活跃时间
    threadPoolTaskExecutor.setKeepAliveSeconds(60);
    // 主线程等待子线程执行时间
    threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
    // 线程名字前缀
    threadPoolTaskExecutor.setThreadNamePrefix("user-info-thread-pool-executor-");
    // RejectedExecutionHandler:当pool已经达到max-size的时候，如何处理新任务
    // CallerRunsPolicy:不在新线程中执行任务，而是由调用者所在的线程来执行
    threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    // 初始化
    threadPoolTaskExecutor.initialize();
    log.info("---------- 线程池加载完成 ----------");
    return threadPoolTaskExecutor;
  }
}
