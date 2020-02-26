package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.CustomerSearchInDTO;
import com.liuhang.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.CustomerShowOutDTO;
import com.liuhang.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){

    }

}
