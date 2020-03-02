package com.liuhang.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuhang.jcartadministrationback.dao.AdministratorMapper;
import com.liuhang.jcartadministrationback.po.Administrator;
import com.liuhang.jcartadministrationback.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper mapper;

    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = mapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public Administrator getByUsername(String username) {
       Administrator administrator= mapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public Integer create(Administrator administrator) {
        mapper.insertSelective(administrator);
        Integer administratorId =administrator.getAdministratorId();
        return administratorId;
    }

    @Override
    public void update(Administrator administrator) {
        mapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public void delete(Integer administratorId) {
        mapper.deleteByPrimaryKey(administratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {
        mapper.batchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        Page<Administrator> page= mapper.selectList();
        return null;
    }
}
