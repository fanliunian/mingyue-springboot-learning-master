package com.csp.mingyue.redis.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.csp.mingyue.redis.mapper.SysUserMapper;
import com.csp.mingyue.redis.model.MingYueUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/** @author Strive */
@Slf4j
@Service
@RequiredArgsConstructor
public class MingYueUserService {

  private final SysUserMapper sysUserMapper;

  private final RedisService redisService;

  private static final String USER_REDIS_KEY = "user:info:";

  /**
   * 根据用户ID查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  public MingYueUser queryUserById(Long userId) {
    log.info("根据用户ID查询用户信息");

    // 查询缓存中是否有查询的数据
    String userJson = redisService.get(USER_REDIS_KEY + userId);

    // 缓存中没有数据则去数据库查询
    if (StrUtil.isBlank(userJson)) {
      log.info("缓存中没有数据则去数据库查询");
      MingYueUser mingYueUser = sysUserMapper.selectById(userId);

      // 查询的结果放入缓存
      redisService.set(USER_REDIS_KEY + userId, JSONUtil.toJsonStr(mingYueUser));

      // 返回查询到的数据
      return mingYueUser;
    }

    log.info("缓存中有对应数据直接返回");
    // 缓存中有对应数据直接返回
    return JSONUtil.toBean(userJson, MingYueUser.class);
  }
}
