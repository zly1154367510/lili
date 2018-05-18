package com.zly.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.OrderMapper;
import com.zly.dao.UserMapper;
import com.zly.model.Order;
import com.zly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/18.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Order> getOrderList(int page) {
        PageHelper.startPage(page,10);
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> getOrderListByUsername(String username,int page) {
        Long uId = userMapper.selectByUsername(username).get(0).getId();
        PageHelper.startPage(page,10);
        return orderMapper.selectAllByUId(uId);
    }

    @Override
    public Long getOrderNum() {
        return orderMapper.selectAllNum();
    }

    @Override
    public Long getOrderNumByUsername(String username) {
        Long uId = userMapper.selectByUsername(username).get(0).getId();
        return orderMapper.selectAllNumByUId(uId);
    }
}
