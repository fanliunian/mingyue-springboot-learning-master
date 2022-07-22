package com.csp.mingyue.mybatis.mapper;

import com.csp.mingyue.mybatis.model.MingYueUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Strive
 * @date 2022/4/20 15:25
 * @description
 */
@Mapper
public interface SysUserMapper {

  /**
   * 根据用户ID查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  MingYueUser queryUserById(Long userId);
}
