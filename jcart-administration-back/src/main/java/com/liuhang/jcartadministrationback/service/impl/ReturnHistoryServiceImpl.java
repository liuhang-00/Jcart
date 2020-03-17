package com.liuhang.jcartadministrationback.service.impl;

import com.liuhang.jcartadministrationback.dao.ReturnHistoryMapper;
import com.liuhang.jcartadministrationback.po.Return;
import com.liuhang.jcartadministrationback.po.ReturnHistory;
import com.liuhang.jcartadministrationback.service.ReturnHistoryService;
import com.liuhang.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper mapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
       List<ReturnHistory> returnHistories = mapper.selectListByReturnId(returnId);
        return returnHistories;
    }

    @Override
    public Long create(ReturnHistory returnHistory) {
        mapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);
        return returnHistoryId;
    }
}
