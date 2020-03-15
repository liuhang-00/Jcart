package com.liuhang.jcartadministrationback.service.impl;

import com.liuhang.jcartadministrationback.dao.OrderHistoryMapper;
import com.liuhang.jcartadministrationback.po.Order;
import com.liuhang.jcartadministrationback.po.OrderHistory;
import com.liuhang.jcartadministrationback.service.OrderHistoryService;
import com.liuhang.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;
    @Autowired
    private OrderService orderService;
    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistories = orderHistoryMapper.selectByOrderId(orderId);

        return orderHistories;
    }

    @Override
    @Transactional
    public Long craete(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        Order order = new Order();

        order.setOrderId(orderHistory.getOrderHistoryId());
        order.setStatus(orderHistory.getOrderStatus());
        order.setUpdateTime(new Date());
        orderService.update(order);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
