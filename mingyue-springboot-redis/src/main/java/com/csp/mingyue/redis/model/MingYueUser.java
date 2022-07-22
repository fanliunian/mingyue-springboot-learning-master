package com.csp.mingyue.redis.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("sys_user")
public class MingYueUser {

  @TableId
  @ApiModelProperty(value = "用户id")
  private Long userId;

  @ApiModelProperty(value = "用户名")
  private String username;
}
