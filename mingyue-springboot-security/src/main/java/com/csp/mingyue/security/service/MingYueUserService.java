package com.csp.mingyue.security.service;

import com.csp.mingyue.security.model.MingYueUser;
import org.springframework.stereotype.Service;

/** @author Strive */
@Service
public class MingYueUserService {

  /**
   * 根据用户名查询用户信息
   *
   * @param username 用户名
   * @return 用户信息
   */
  public MingYueUser queryUserByName(String username) {
    return MingYueUser.builder().userId(1L).username(username).password("123456").build();
  }
}
