package com.liuhang.jcartadministrationback.service;

import com.liuhang.jcartadministrationback.po.Address;

import java.util.List;

public interface AddressService {
    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

}
