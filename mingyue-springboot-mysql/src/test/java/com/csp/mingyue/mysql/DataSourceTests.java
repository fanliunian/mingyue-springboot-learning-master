package com.csp.mingyue.mysql;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Strive
 * @date 2022/4/20 10:35
 * @description
 */
@SpringBootTest
public class DataSourceTests {
  @Autowired private DataSource dataSource;

  @Test
  public void testConnection() throws Exception {
    System.out.println(dataSource.getConnection());
  }
}
