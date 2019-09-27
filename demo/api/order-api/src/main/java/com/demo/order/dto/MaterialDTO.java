package com.demo.order.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
@ApiModel(description = "材料管理DTO")
public class MaterialDTO {
  @ApiModelProperty(value = "材料id", notes = "材料id",required = true)
  private String id;

  /**
   * 材料名称
   */
  @ApiModelProperty(value = "材料名称", notes = "材料名称",required = true)
  private String name;

  /**
   * 材料数量
   */
  @ApiModelProperty(value = "材料数量", notes = "材料数量",required = true)
  private Long quantity;

  /**
   * 材料价钱
   */
  @ApiModelProperty(value = "材料价钱", notes = "材料价钱",required = true)
  private BigDecimal price;

  /**
   * 材料规格
   */
  @ApiModelProperty(value = "材料规格", notes = "材料规格",required = true)
  private String specification;

}
