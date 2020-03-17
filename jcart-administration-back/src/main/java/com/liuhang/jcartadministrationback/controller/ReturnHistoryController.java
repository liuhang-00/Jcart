package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.ReturnHistoryCreateInDTO;
import com.liuhang.jcartadministrationback.dto.out.ReturnHistoryListOutDTO;
import com.liuhang.jcartadministrationback.po.ReturnHistory;
import com.liuhang.jcartadministrationback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnhistory")
@CrossOrigin
public class ReturnHistoryController {
    @Autowired
    private ReturnHistoryService service;

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        List<ReturnHistory> listByReturnId = service.getListByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = listByReturnId.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setReturnHistoryId(returnHistory.getReturnId());
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            returnHistoryListOutDTO.setCustomerNotified(returnHistory.getCustomerNotified());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());

        return returnHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Long create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        ReturnHistory returnHistory = new ReturnHistory();

        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        Boolean customerNotifeid = returnHistoryCreateInDTO.getCustomerNotifeid();
        returnHistory.setCustomerNotified(customerNotifeid);
        Long aLong = service.create(returnHistory);
        if(customerNotifeid!=null&&customerNotifeid){

        }
        return aLong;
    }

}
