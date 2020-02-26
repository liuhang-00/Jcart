package com.liuhang.jcartstoreback.service;


import com.liuhang.jcartstoreback.dto.out.ProductShowOutDTO;

public interface ProductService {

    ProductShowOutDTO getById(Integer productId);

}
