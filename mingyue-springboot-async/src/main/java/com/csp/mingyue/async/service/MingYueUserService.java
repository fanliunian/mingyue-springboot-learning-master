package com.csp.mingyue.async.service;

import cn.hutool.core.map.MapUtil;
import com.csp.mingyue.async.model.MingYueUser;
import com.csp.mingyue.async.tasks.MingYueUserAsyncTask;
import java.util.Map;
import java.util.concurrent.Future;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/** @author Strive */
@Slf4j
@Service
@RequiredArgsConstructor
public class MingYueUserService {

  private final MingYueUserAsyncTask mingYueUserAsyncTask;

  /** 模拟用户存储 */
  private static final Map<Long, MingYueUser> USER_MAP = MapUtil.newHashMap();

  static {
    USER_MAP.put(1L, MingYueUser.builder().userId(1L).username("mingyue").build());
  }

  /**
   * 根据用户ID查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  public MingYueUser queryUserById(Long userId) {
    long start = System.currentTimeMillis();

    // 1. 先查询用户信息
    MingYueUser mingYueUser = USER_MAP.get(userId);
    /*
     * 同时查询用户部门或角色信息
     */
    // 1.异步查询部门信息
    Future<Boolean> deptInfo = mingYueUserAsyncTask.queryDeptInfo(mingYueUser);
    // 2.异步查询角色信息
    Future<Boolean> roleInfo = mingYueUserAsyncTask.queryRoleInfo(mingYueUser);

    while (!deptInfo.isDone() || !roleInfo.isDone()) {
      // 当所有的任务都执行完时，退出
      if (deptInfo.isDone() && roleInfo.isDone()) {
        break;
      }
    }
    long end = System.currentTimeMillis();
    log.info("任务全部完成，总耗时：({})毫秒", end - start);
    return USER_MAP.get(userId);
  }
}
