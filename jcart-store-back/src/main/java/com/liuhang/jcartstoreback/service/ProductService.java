package com.liuhang.jcartstoreback.service;


import com.github.pagehelper.Page;
import com.liuhang.jcartstoreback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartstoreback.dto.out.ProductListOutDTO;
import com.liuhang.jcartstoreback.dto.out.ProductShowOutDTO;

public interface ProductService {

    ProductShowOutDTO getById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum, ProductSearchInDTO productSearchInDTO);

}
