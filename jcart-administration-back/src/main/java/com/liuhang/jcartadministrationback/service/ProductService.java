package com.liuhang.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.liuhang.jcartadministrationback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.liuhang.jcartadministrationback.dto.out.ProductListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.ProductShowOutDTO;

import java.util.List;

public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);

    Page<ProductListOutDTO> search(Integer pageNum, ProductSearchInDTO productSearchInDTO);

    ProductShowOutDTO getById(Integer productId);

}
