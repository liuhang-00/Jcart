package com.liuhang.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.liuhang.jcartadministrationback.dto.out.*;
import com.liuhang.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<OrderListOutDTO> page= service.search(pageNum);
        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setList(page);
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = service.getById(orderId);
        return orderShowOutDTO;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){
        return null;
    }

}
