package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.out.AddressListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.AddressShowOutDTO;
import com.liuhang.jcartadministrationback.po.Address;
import com.liuhang.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId){
        List<Address> addresses = service.getByCustomerId(customerId);
        List<AddressListOutDTO> addressListOutDTOS = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setContent(address.getContent());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setTag(address.getTag());
            return addressListOutDTO;
        }).collect(Collectors.toList());
        return addressListOutDTOS;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        Address address = service.getById(addressId);
        AddressShowOutDTO addressShowOutDTO= new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setContent(address.getContent());
        addressShowOutDTO.setReceiverMoblie(address.getContent());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setTag(address.getTag());
        return addressShowOutDTO;
    }

}
