package com.liuhang.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuhang.jcartadministrationback.dao.OrderDetailMapper;
import com.liuhang.jcartadministrationback.dao.OrderMapper;
import com.liuhang.jcartadministrationback.dto.out.OrderListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.liuhang.jcartadministrationback.po.Customer;
import com.liuhang.jcartadministrationback.po.Order;
import com.liuhang.jcartadministrationback.po.OrderDetail;
import com.liuhang.jcartadministrationback.service.CustomerService;
import com.liuhang.jcartadministrationback.service.OrderService;
import com.liuhang.jcartadministrationback.vo.OrderProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Order order  = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        Customer customer = custoemrService.getById(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getRealName());
        orderShowOutDTO.setStatus(customer.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());
        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());
        List<OrderProductVo> orderProductVos = JSON.parseArray(orderDetail.getOrderProducts(),OrderProductVo.class);
        orderShowOutDTO.setOrderProducts(orderProductVos);
        return orderShowOutDTO;
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
