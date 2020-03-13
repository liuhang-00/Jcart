package com.liuhang.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuhang.jcartadministrationback.dao.CustomerMapper;
import com.liuhang.jcartadministrationback.dto.in.CustomerSearchInDTO;
import com.liuhang.jcartadministrationback.po.Customer;
import com.liuhang.jcartadministrationback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper mapper;

    @Override
    public Page<Customer> search(CustomerSearchInDTO customerSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        Page<Customer> page = mapper.search(customerSearchInDTO.getUsername(),
                customerSearchInDTO.getRealName(),
                customerSearchInDTO.getMobile(),
                customerSearchInDTO.getEmail(),
                customerSearchInDTO.getStatus());
        return page;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = mapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void setStatus(CustomerSearchInDTO customerSearchInDTO) {

    }
}
