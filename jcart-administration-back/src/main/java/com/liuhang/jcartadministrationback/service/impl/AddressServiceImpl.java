package com.liuhang.jcartadministrationback.service.impl;

import com.liuhang.jcartadministrationback.dao.AddressMapper;
import com.liuhang.jcartadministrationback.po.Address;
import com.liuhang.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper mapper;

    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> addresses = mapper.selectByCustomerId(customerId);
        return addresses;
    }

    @Override
    public Address getById(Integer addressId) {
        Address address = mapper.selectByPrimaryKey(addressId);
        return address;
    }
}
