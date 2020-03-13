package com.liuhang.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.out.OrderListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.liuhang.jcartadministrationback.po.Order;

public interface OrderService {
    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);
}
