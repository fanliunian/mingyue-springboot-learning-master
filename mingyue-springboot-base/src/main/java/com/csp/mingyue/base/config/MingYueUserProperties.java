package com.csp.mingyue.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** @author Strive */
@Component
@ConfigurationProperties(prefix = "mingyue")
public class MingYueUserProperties {
  private Long id;
  private String name;
  private String sex;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "MingYueUserProperties{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", sex='"
        + sex
        + '\''
        + '}';
  }
}
