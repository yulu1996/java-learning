package com.demo.order.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
@ApiModel(description = "订单管理DTO")
public class OrderDTO {

  @ApiModelProperty(value = "订单id", notes = "订单id",required = true)
  private String id;

  /**
   * 产品名称
   */
  @ApiModelProperty(value = "产品名称", notes = "产品名称",required = true)
  private String productName;

  /**
   * 产品数量
   */
  @ApiModelProperty(value = "产品数量", notes = "产品数量",required = true)
  private String productQuantity;

  /**
   * 客户id
   */
  @ApiModelProperty(value = "客户id", notes = "客户id",required = true)
  private String customerId;

  /**
   * 客户名称
   */
  @ApiModelProperty(value = "客户名称", notes = "客户名称")
  private String customerName;

  /**
   * 客户地址
   */
  @ApiModelProperty(value = "客户地址", notes = "客户地址")
  private String customerAddress;

  /**
   * 客户电话
   */
  @ApiModelProperty(value = "客户联系电话", notes = "客户联系电话")
  private String customerPhone;

  /**
   * 生产车间
   */
  @ApiModelProperty(value = "生产车间", notes = "生产车间",required = true)
  private String workshop;

  /**
   * 材料
   */
  @ApiModelProperty(value = "所需材料", notes = "所需材料",required = true)
  private List<MaterialDTO> materials;

  /**
   * 生产截止日期
   */
  @ApiModelProperty(value = "生产截止日期", notes = "生产截止日期",required = true)
  private Date deadline;

  /**
   * 订单总价钱
   */
  @ApiModelProperty(value = "价钱", notes = "价钱",required = true)
  private BigDecimal price;

  /**
   * 订单状态
   */
  @ApiModelProperty(value = "订单状态", notes = "启动/停止/删除",required = true)
  private String status;

}
