package com.csp.mingyue.es;

import java.io.IOException;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Strive
 * @date 2022/4/20 10:35
 * @description
 */
@SpringBootTest
public class ElasticsearchTest {

  @Autowired
  @Qualifier("elasticsearchClient")
  public RestHighLevelClient client;

  /** 创建索引测试 */
  @Test
  public void createIndexTest() throws IOException {
    CreateIndexRequest request = new CreateIndexRequest("mingyue");
    CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

    // 查看是否创建成功
    System.out.println(response.isAcknowledged());
    client.close();
  }
}
