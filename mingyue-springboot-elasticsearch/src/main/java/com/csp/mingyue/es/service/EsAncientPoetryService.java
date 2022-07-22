package com.csp.mingyue.es.service;

import com.csp.mingyue.es.model.AncientPoetry;
import com.csp.mingyue.es.repository.EsAncientPoetryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ESAncientPoetry service 层
 *
 * @author Strive
 * @date 2022/4/26 10:07
 */
@Service
@RequiredArgsConstructor
public class EsAncientPoetryService {

  private final EsAncientPoetryRepository esAncientPoetryRepository;

  /**
   * 添加古诗词到ES
   *
   * @param ancientPoetry 古诗词
   */
  public boolean addAncientPoetry(AncientPoetry ancientPoetry) {
    esAncientPoetryRepository.save(ancientPoetry);
    return Boolean.TRUE;
  }

  /**
   * 根据ID查询古诗词
   *
   * @param id 古诗词ID
   */
  public AncientPoetry getById(String id) {
    Optional<AncientPoetry> ancientPoetryOptional = esAncientPoetryRepository.findById(id);

    return ancientPoetryOptional.orElse(null);
  }

  /**
   * 关键字检索 标题 或 内容
   *
   * @param keyword 关键字
   */
  public List<AncientPoetry> findAncientPoetry(String keyword) {
    return esAncientPoetryRepository.findByTitleOrContent(keyword, keyword);
  }
}
