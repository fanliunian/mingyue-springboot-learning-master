package com.csp.mingyue.es.repository;

import com.csp.mingyue.es.model.AncientPoetry;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 古诗词 ES 该接口继承了ElasticsearchRepository接口，ElasticsearchRepository接口定义了Elasticsearch的CRUD，
 * 继承了该接口的接口甚至无需定义任何其他的方法就能满足基本需求。
 *
 * @author Strive
 * @date 2022/4/26 09:46
 * @description
 */
public interface EsAncientPoetryRepository extends ElasticsearchRepository<AncientPoetry, String> {
  /**
   * 关键字检索 标题 或 内容
   *
   * @param title 标题
   * @param content 内容
   * @return 古诗词列表
   */
  List<AncientPoetry> findByTitleOrContent(String title, String content);
}
