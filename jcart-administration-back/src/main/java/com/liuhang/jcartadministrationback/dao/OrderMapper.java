package com.liuhang.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.out.OrderListOutDTO;
import com.liuhang.jcartadministrationback.po.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search();
}