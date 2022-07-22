package com.csp.mingyue.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** @author Strive */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MingYueUser {
  private Long userId;
  private String username;
  private String password;
}
