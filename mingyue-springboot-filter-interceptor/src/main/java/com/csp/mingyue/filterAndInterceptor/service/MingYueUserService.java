package com.csp.mingyue.filterAndInterceptor.service;

import cn.hutool.core.map.MapUtil;
import com.csp.mingyue.filterAndInterceptor.model.MingYueUser;
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

  /**
   * 添加用户
   *
   * @param user 用户信息
   * @return 新用户ID
   */
  public Long addUser(MingYueUser user) {
    USER_MAP.put(2L, user);

    return user.getUserId();
  }

  /**
   * 更新用户
   *
   * @param user 用户信息
   */
  public String updateUser(MingYueUser user) {
    MingYueUser mingYueUser = USER_MAP.get(user.getUserId());

    USER_MAP.put(user.getUserId(), user);

    return mingYueUser.getUsername() + " 更新为：" + user.getUsername();
  }

  /**
   * 根据用户ID删除用户
   *
   * @param userId 用户ID
   */
  public String deleteUser(Long userId) {
    int size = USER_MAP.size();

    USER_MAP.remove(userId);

    return "原" + size + "用户，删除后还有" + USER_MAP.size();
  }
}
