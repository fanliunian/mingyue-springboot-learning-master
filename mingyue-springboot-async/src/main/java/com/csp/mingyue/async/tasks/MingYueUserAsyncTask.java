package com.csp.mingyue.async.tasks;

import com.csp.mingyue.async.model.MingYueUser;
import java.util.concurrent.Future;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 用户异步任务
 *
 * @author Strive
 */
@Slf4j
@Component
public class MingYueUserAsyncTask {

  /** 查询用户部门信息 */
  @Async
  @SneakyThrows
  public Future<Boolean> queryDeptInfo(MingYueUser mingYueUser) {
    long start = System.currentTimeMillis();
    Thread.sleep(1000);
    long end = System.currentTimeMillis();
    log.info("{}：查询用户部门信息耗时：({})毫秒", mingYueUser.getUsername(), (end - start));
    return new AsyncResult<>(true);
  }

  /** 查询用户角色信息 */
  @Async
  @SneakyThrows
  public Future<Boolean> queryRoleInfo(MingYueUser mingYueUser) {
    long start = System.currentTimeMillis();
    Thread.sleep(500);
    long end = System.currentTimeMillis();
    log.info("{}：查询用户角色信息耗时：({})毫秒", mingYueUser.getUsername(), (end - start));
    return new AsyncResult<>(true);
  }
}
