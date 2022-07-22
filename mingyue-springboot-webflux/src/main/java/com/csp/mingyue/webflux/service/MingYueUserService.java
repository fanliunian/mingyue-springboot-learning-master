package com.csp.mingyue.webflux.service;

import cn.hutool.core.map.MapUtil;
import com.csp.mingyue.webflux.model.MingYueUser;
import java.util.Map;
import org.springframework.stereotype.Service;

/** @author Strive */
@Service
public class MingYueUserService {

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
    return USER_MAP.get(userId);
  }
}
