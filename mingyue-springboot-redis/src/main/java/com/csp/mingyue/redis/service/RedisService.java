package com.csp.mingyue.redis.service;

/**
 * Redis 操作 Service
 *
 * @author Strive
 * @date 2022/4/21 10:02
 * @description
 */
public interface RedisService {
  /** 存储数据 */
  void set(String key, String value);

  /** 获取数据 */
  String get(String key);

  /** 设置超期时间 */
  boolean expire(String key, long expire);

  /** 删除数据 */
  void remove(String key);

  /** 自增操作 */
  Long increment(String key, long delta);
}
