package com.csp.mingyue.base.lombok.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** @author Strive */
@Data
@ToString
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "mingyue")
public class MingYueUserProperties {
  private Long id;
  private String name;
  private String sex;

  public static void main(String[] args) {
    MingYueUserProperties example =
        MingYueUserProperties.builder().id(2L).name("Strive").sex("男").build();
    System.out.println(example);
  }
}
