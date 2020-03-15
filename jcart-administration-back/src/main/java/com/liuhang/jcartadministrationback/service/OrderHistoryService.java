package com.liuhang.jcartadministrationback.service;

import com.liuhang.jcartadministrationback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

    Long craete(OrderHistory orderHistory);
}
