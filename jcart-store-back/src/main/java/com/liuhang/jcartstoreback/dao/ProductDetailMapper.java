package com.liuhang.jcartstoreback.dao;

import com.github.pagehelper.Page;
import com.liuhang.jcartstoreback.dto.in.ProductSearchInDTO;
import com.liuhang.jcartstoreback.dto.out.ProductListOutDTO;
import com.liuhang.jcartstoreback.po.ProductDetail;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    Page<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO);
}