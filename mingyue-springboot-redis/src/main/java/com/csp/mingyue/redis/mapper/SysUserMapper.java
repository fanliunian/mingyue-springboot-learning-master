package com.csp.mingyue.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csp.mingyue.redis.model.MingYueUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Strive
 * @date 2022/4/20 15:25
 * @description
 */
@Mapper
public interface SysUserMapper extends BaseMapper<MingYueUser> {}
