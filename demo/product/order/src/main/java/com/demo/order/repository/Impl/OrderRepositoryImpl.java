package com.demo.order.repository.Impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.demo.order.model.Order;
import com.demo.order.repository.OrderRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<Order> getOrderBySearchable(String productName, Long deadline, String status,
                                          int size, int page) {
    PageRequest pageRequest = PageRequest.of(page,size);
    CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> root = criteriaQuery.from(Order.class);
    criteriaQuery.select(root);
    //过滤条件用Predicate方法拼接
    Predicate predicate = criteriaBuilder.conjunction();
    if(!StringUtils.isEmpty(productName)) {
      predicate = criteriaBuilder.like(root.get("productName"), "%"+productName+"%");
    }
    if(deadline!=null) {
      Date date = new Date(deadline);
      predicate = criteriaBuilder.lessThanOrEqualTo(root.get("deadline"),date);
    }
    if(!StringUtils.isEmpty(status)) {
      predicate = criteriaBuilder.equal(root.get("status"),status);
    }
    criteriaQuery.where(predicate);
    TypedQuery<Order> query = this.entityManager.createQuery(criteriaQuery);
    List<Order> orderList = query.getResultList();

    Page<Order> orderPage = new PageImpl<Order>(orderList, pageRequest, orderList.size());
    return orderPage;
  }
}
