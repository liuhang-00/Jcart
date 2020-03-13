package com.liuhang.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuhang.jcartadministrationback.dao.OrderDetailMapper;
import com.liuhang.jcartadministrationback.dao.OrderMapper;
import com.liuhang.jcartadministrationback.dto.out.OrderListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.liuhang.jcartadministrationback.po.Order;
import com.liuhang.jcartadministrationback.service.CustomerService;
import com.liuhang.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private CustomerService custoemrService;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        Page<OrderListOutDTO> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        return null;
    }

    @Override
    public void update(Order order) {

    }
}
