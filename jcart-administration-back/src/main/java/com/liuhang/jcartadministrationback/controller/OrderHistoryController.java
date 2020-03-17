package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.liuhang.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import com.liuhang.jcartadministrationback.po.OrderHistory;
import com.liuhang.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderhistory")
@CrossOrigin
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService service;

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        List<OrderHistory> byOrderId = service.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS= byOrderId.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setOrderHistoryId(orderHistory.getOrderHistoryId());
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            orderHistoryListOutDTO.setCustomerNotified(orderHistory.getCustomerNotified());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());
        return orderHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(orderHistoryCreateInDTO.getOrderId());
        orderHistory.setTime(new Date());
        orderHistory.setOrderStatus(orderHistoryCreateInDTO.getOrderStatus());
        orderHistory.setComment(orderHistoryCreateInDTO.getComment());
        orderHistory.setCustomerNotified(orderHistoryCreateInDTO.getCustomerNotified());
        Long orderHistoryId = service.craete(orderHistory);
        return orderHistoryId;
    }

}
