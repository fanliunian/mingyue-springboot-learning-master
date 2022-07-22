package com.csp.mingyue.filterAndInterceptor.controller;

import cn.hutool.json.JSONUtil;
import com.csp.mingyue.filterAndInterceptor.model.MingYueUser;
import com.csp.mingyue.filterAndInterceptor.service.MingYueUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Strive */
@Api(tags = "用户模块")
@Slf4j
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

  @ApiOperation("添加用户")
  @PostMapping
  public ResponseEntity<String> addUser(
      @RequestBody @Validated MingYueUser user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.ok(JSONUtil.toJsonStr(bindingResult.getFieldErrors()));
    }

    return ResponseEntity.ok(mingYueUserService.addUser(user).toString());
  }

  @ApiOperation("更新用户")
  @PutMapping
  public ResponseEntity<String> updateUser(@RequestBody MingYueUser user) {
    return ResponseEntity.ok(mingYueUserService.updateUser(user));
  }

  @ApiOperation("根据用户ID删除用户")
  @DeleteMapping("/{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    return ResponseEntity.ok(mingYueUserService.deleteUser(userId));
  }
}
