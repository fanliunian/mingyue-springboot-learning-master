package com.csp.mingyue.mybatis.controller;

import com.csp.mingyue.mybatis.model.MingYueUser;
import com.csp.mingyue.mybatis.service.MingYueUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Strive */
@Api(tags = "用户模块")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MingYueUserController {

  private final MingYueUserService mingYueUserService;

  @ApiOperation("根据用户ID查询用户信息")
  @GetMapping("/{userId}")
  public ResponseEntity<MingYueUser> queryUserById(@PathVariable Long userId) {
    return ResponseEntity.ok(mingYueUserService.queryUserById(userId));
  }
}
