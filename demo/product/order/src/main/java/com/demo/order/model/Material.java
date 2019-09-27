package com.demo.order.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_material")
@Getter
@Setter
public class Material implements Serializable {
  private static final long serialVersionUID = -4782699467513501418L;

  @Id
  @GenericGenerator(name = "generateUUID", strategy = "uuid")
  @GeneratedValue(generator = "generateUUID")
  private String id;

  /**
   * 材料名称
   */
  private String name;

  /**
   * 材料数量
   */
  private Long quantity;

  /**
   * 材料价钱
   */
  private BigDecimal price;

  /**
   * 材料规格
   */
  private String specification;

  @Version
  private Long version;
}
