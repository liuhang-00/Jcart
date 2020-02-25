package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.liuhang.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.liuhang.jcartadministrationback.dto.out.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(OrderSearchInDTO orderSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }

    @PostMapping("/createHistory")
    public OrderHistoryCreateInDTO createHistory(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        return null;
    }

    @GetMapping("/showInvoice")
    public OrderInvoiceShowOutDTO showInvoice(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/showShip")
    public OrderShipShowOutDTO showShip(@RequestParam Long orderId){
        return null;
    }
}
