package com.demo.user.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
@ApiModel(description = "客户管理DTO")
public class CustomerDTO {

  @ApiModelProperty(value = "客户id", notes = "客户id",required = true)
  private String id;

  /**
   * 客户名称
   */
  @ApiModelProperty(value = "客户名称", notes = "客户名称",required = true)
  private String name;

  /**
   * 客户地址
   */
  @ApiModelProperty(value = "客户地址", notes = "客户地址",required = true)
  private String address;

  /**
   * 客户联系电话
   */
  @ApiModelProperty(value = "客户联系电话", notes = "客户联系电话",required = true)
  private String phone;

}
