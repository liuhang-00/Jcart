package com.liuhang.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.liuhang.jcartadministrationback.dto.in.ReturnSearchInDTO;
import com.liuhang.jcartadministrationback.po.Return;

public interface ReturnService {
    Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);

}
