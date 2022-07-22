package com.csp.mingyue.mybatis.service;

import com.csp.mingyue.mybatis.mapper.SysUserMapper;
import com.csp.mingyue.mybatis.model.MingYueUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** @author Strive */
@Service
@RequiredArgsConstructor
public class MingYueUserService {

  private final SysUserMapper sysUserMapper;

  /**
   * 根据用户ID查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  public MingYueUser queryUserById(Long userId) {
    return sysUserMapper.queryUserById(userId);
  }
}
