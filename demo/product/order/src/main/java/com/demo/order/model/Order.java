package com.demo.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.demo.order.util.ListConverter;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_order")
@Getter
@Setter
public class Order implements Serializable {
  private static final long serialVersionUID = -5642197013936317492L;

  @Id
  @GenericGenerator(name = "generateUUID", strategy = "uuid")
  @GeneratedValue(generator = "generateUUID")
  private String id;

  /**
   * 产品名称
   */
  private String productName;

  /**
   * 产品数量
   */
  private String productQuantity;

  /**
   * 客户id
   */
  private String customerId;

  /**
   * 客户名称
   */
  private String customerName;

  /**
   * 客户地址
   */
  private String customerAddress;

  /**
   * 客户电话
   */
  private String customerPhone;

  /**
   * 生产车间
   */
  private String workshop;

  /**
   * 材料
   */
  @ManyToMany
  @JoinTable(name = "t_order_material",joinColumns =@JoinColumn(name = "order_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "material_id",referencedColumnName = "id"))
  private List<Material> materials = Lists.newArrayList();

  /**
   * 生产截止日期
   */
  private Date deadline;

  /**
   * 订单总价钱
   */
  private BigDecimal price;

  /**
   * 订单状态
   */
  private String status;

  @Version
  private Long version;
}
