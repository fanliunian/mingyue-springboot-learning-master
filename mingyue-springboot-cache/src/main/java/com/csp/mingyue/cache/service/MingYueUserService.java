package com.csp.mingyue.cache.service;

import com.csp.mingyue.cache.mapper.SysUserMapper;
import com.csp.mingyue.cache.model.MingYueUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** @author Strive */
@Slf4j
@Service
@RequiredArgsConstructor
public class MingYueUserService {

  private final SysUserMapper sysUserMapper;

  private static final String USER_REDIS_KEY = "'user:info:'";

  private static final String REDIS_KEY_DATABASE = "mingyue";

  /**
   * 根据用户ID查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  @Cacheable(
      value = REDIS_KEY_DATABASE,
      key = USER_REDIS_KEY + "+#userId",
      unless = "#result==null")
  public MingYueUser queryUserById(Long userId) {
    log.info("根据用户ID查询用户信息");
    return sysUserMapper.selectById(userId);
  }
}
