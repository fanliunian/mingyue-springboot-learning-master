package com.csp.mingyue.base.controller;

import com.csp.mingyue.base.config.MingYueUserProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Strive */
@RestController
public class MingYueController {

  private static final Logger log = LoggerFactory.getLogger(MingYueController.class);

  @Autowired private MingYueUserProperties mingYueUserProperties;

  @GetMapping("/mingYue")
  public String mingYue() {
    log.info("==== into mingYue api ====");
    return mingYueUserProperties.toString();
  }
}
