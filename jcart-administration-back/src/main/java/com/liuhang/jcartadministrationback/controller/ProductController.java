package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.liuhang.jcartadministrationback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.liuhang.jcartadministrationback.dto.out.PageOutDTO;
import com.liuhang.jcartadministrationback.dto.out.ProductListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
    @GetMapping("/getList")
    public PageOutDTO<ProductListOutDTO> getList(@RequestBody ProductSearchInDTO productSearchInDTO){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    @GetMapping("/show")
    public ProductShowOutDTO show(@RequestParam Integer productId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }
}
