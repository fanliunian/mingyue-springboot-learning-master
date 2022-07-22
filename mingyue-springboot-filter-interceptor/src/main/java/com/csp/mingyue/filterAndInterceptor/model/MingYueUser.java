package com.csp.mingyue.filterAndInterceptor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel(value = "用户实体类", description = "用户信息描述类")
public class MingYueUser {

  @NotNull(message = "用户id不能为空")
  @ApiModelProperty(value = "用户id")
  private Long userId;

  @NotBlank(message = "用户名不能为空")
  @ApiModelProperty(value = "用户名")
  private String username;
}
