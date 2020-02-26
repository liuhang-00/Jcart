package com.liuhang.jcartstoreback.controller;

import com.liuhang.jcartstoreback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartstoreback.dto.out.PageOutDTO;
import com.liuhang.jcartstoreback.dto.out.ProductListOutDTO;
import com.liuhang.jcartstoreback.dto.out.ProductShowOutDTO;
import com.liuhang.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

}
