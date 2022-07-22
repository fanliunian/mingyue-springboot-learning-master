package com.csp.mingyue.security.controller;

import com.csp.mingyue.security.model.MingYueUser;
import com.csp.mingyue.security.service.MingYueUserService;
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

  @GetMapping("/{username}")
  public ResponseEntity<MingYueUser> queryUserByName(@PathVariable String username) {
    return ResponseEntity.ok(mingYueUserService.queryUserByName(username));
  }
}
