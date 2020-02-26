package com.liuhang.jcartstoreback.controller;

import com.liuhang.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.liuhang.jcartstoreback.dto.out.OrderListOutDTO;
import com.liuhang.jcartstoreback.dto.out.OrderShowOutDTO;
import com.liuhang.jcartstoreback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
