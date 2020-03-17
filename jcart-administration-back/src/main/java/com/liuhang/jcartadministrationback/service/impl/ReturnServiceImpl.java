package com.liuhang.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuhang.jcartadministrationback.dao.ReturnMapper;
import com.liuhang.jcartadministrationback.dto.in.ReturnSearchInDTO;
import com.liuhang.jcartadministrationback.po.Return;
import com.liuhang.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper mapper;
    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        Page<Return> page  = mapper.search(returnSearchInDTO.getReturnId(),
                returnSearchInDTO.getOrderId(),
                returnSearchInDTO.getStartTimestap()==null?null:new Date(returnSearchInDTO.getStartTimestap()),
                returnSearchInDTO.getEndTimestamp()==null?null:new Date(returnSearchInDTO.getEndTimestamp()),
                returnSearchInDTO.getStatus(),
                returnSearchInDTO.getProductCode(),
                returnSearchInDTO.getCustomerName(),
                returnSearchInDTO.getProductName());
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = mapper.selectByPrimaryKey(returnId);

        return aReturn;
    }

    @Override
    public void update(Return aReturn) {
        mapper.updateByPrimaryKeySelective(aReturn);
    }
}
