package com.csp.mingyue.async.controller;

import com.csp.mingyue.async.model.MingYueUser;
import com.csp.mingyue.async.service.MingYueUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Strive */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MingYueUserController {

  private final MingYueUserService mingYueUserService;

  @GetMapping("/{userId}")
  public ResponseEntity<MingYueUser> queryUserById(@PathVariable Long userId) {
    return ResponseEntity.ok(mingYueUserService.queryUserById(userId));
  }
}
