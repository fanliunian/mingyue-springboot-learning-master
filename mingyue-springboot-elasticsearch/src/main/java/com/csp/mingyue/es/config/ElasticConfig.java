package com.csp.mingyue.es.config;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * Elasticsearch 配置类
 *
 * @author Strive
 */
@Slf4j
@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {
  @Value("${elastic.address}")
  private List<String> addressList;

  @Bean
  @Override
  public RestHighLevelClient elasticsearchClient() {
    HttpHost[] httpHosts = new HttpHost[addressList.size()];

    for (int i = 0; i < addressList.size(); i++) {
      String address = addressList.get(i);

      log.info("create elastic host:{}", address);
      httpHosts[i] = HttpHost.create(address);
    }
    return new RestHighLevelClient(RestClient.builder(httpHosts));
  }
}
