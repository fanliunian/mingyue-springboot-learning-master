package com.csp.mingyue.es.controller;

import com.csp.mingyue.es.model.AncientPoetry;
import com.csp.mingyue.es.service.EsAncientPoetryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ES 操作接口
 *
 * @author Strive
 * @date 2022/4/26 09:52
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/es/ancientPoetry")
public class EsAncientPoetryController {

  private final EsAncientPoetryService esAncientPoetryService;

  @PostMapping
  public ResponseEntity<Boolean> add(@RequestBody AncientPoetry ancientPoetry) {
    return ResponseEntity.ok(esAncientPoetryService.addAncientPoetry(ancientPoetry));
  }

  @GetMapping("{id}")
  public ResponseEntity<AncientPoetry> get(@PathVariable String id) {
    return ResponseEntity.ok(esAncientPoetryService.getById(id));
  }

  @GetMapping("/search")
  public ResponseEntity<List<AncientPoetry>> findAncientPoetry(String keyword) {
    return ResponseEntity.ok(esAncientPoetryService.findAncientPoetry(keyword));
  }
}
