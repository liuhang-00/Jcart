package com.liuhang.jcartstoreback.controller;

import com.github.pagehelper.Page;
import com.liuhang.jcartstoreback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartstoreback.dto.out.PageOutDTO;
import com.liuhang.jcartstoreback.dto.out.ProductListOutDTO;
import com.liuhang.jcartstoreback.dto.out.ProductShowOutDTO;
import com.liuhang.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        Page<ProductListOutDTO> search = productService.search(pageNum, productSearchInDTO);
        PageOutDTO<ProductListOutDTO> page= new PageOutDTO<>();
        page.setList(search);
        page.setPageNum(search.getPageNum());
        page.setPageSize(search.getPageSize());
        page.setTotal(search.getTotal());
        return page;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

}
