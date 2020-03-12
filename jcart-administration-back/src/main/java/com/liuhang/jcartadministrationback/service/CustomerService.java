package com.liuhang.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.in.CustomerSearchInDTO;
import com.liuhang.jcartadministrationback.po.Customer;

public interface CustomerService {
    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO,Integer pageNum);

    Customer getById(Integer customer);

    void setStatus(CustomerSearchInDTO customerSearchInDTO);
}
