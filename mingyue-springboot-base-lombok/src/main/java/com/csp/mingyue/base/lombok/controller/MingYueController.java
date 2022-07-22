package com.csp.mingyue.base.lombok.controller;

import com.csp.mingyue.base.lombok.config.MingYueUserProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Strive */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MingYueController {

  private final MingYueUserProperties mingYueUserProperties;

  @GetMapping("/mingYue")
  @SneakyThrows
  public String mingYue(Integer type) {
    log.info("==== into mingYue api ====");

    if (null != type && type == 0) {
      throw new Exception("type 等于 0");
    }

    return mingYueUserProperties.toString();
  }
}
