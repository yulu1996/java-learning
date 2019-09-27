package com.demo.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "t_customer")
@Entity
@Getter
@Setter
public class Customer implements Serializable {


  private static final long serialVersionUID = -6485920655385221870L;

  @Id
  @GenericGenerator(name = "generateUUID", strategy = "uuid")
  @GeneratedValue(generator = "generateUUID")
  private String id;

  /**
   * 客户名称
   */
  private String name;

  /**
   * 客户地址
   */
  private String address;

  /**
   * 客户联系电话
   */
  private String phone;

  @Version
  private Long version;
}
