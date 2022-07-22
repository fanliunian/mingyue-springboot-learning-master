package com.csp.mingyue.redis.service.impl;

import com.csp.mingyue.redis.service.RedisService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Redis 操作 Service 的实现类
 *
 * @author Strive
 * @date 2022/4/21 10:03
 * @description
 */
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {
  private final StringRedisTemplate stringRedisTemplate;

  @Override
  public void set(String key, String value) {
    stringRedisTemplate.opsForValue().set(key, value);
  }

  @Override
  public String get(String key) {
    return stringRedisTemplate.opsForValue().get(key);
  }

  @Override
  public boolean expire(String key, long expire) {
    return Boolean.TRUE.equals(stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS));
  }

  @Override
  public void remove(String key) {
    stringRedisTemplate.delete(key);
  }

  @Override
  public Long increment(String key, long delta) {
    return stringRedisTemplate.opsForValue().increment(key, delta);
  }
}
