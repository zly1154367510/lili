package com.zly.service;

import com.zly.model.Order;

import java.util.List;

/**
 * Created by zly11 on 2018/5/18.
 */
public interface OrderService {

    List<Order> getOrderList(int page);
    List<Order> getOrderListByUsername(String username,int page);
    Long getOrderNum();
    Long getOrderNumByUsername(String username);

}
