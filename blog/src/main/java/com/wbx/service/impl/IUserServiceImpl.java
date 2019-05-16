package com.wbx.service.impl;

import com.wbx.domain.User;
import com.wbx.mapper.IUserMapper;
import com.wbx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserMapper iUserMapper;

    @Override
    public User findById(int id) {
        return iUserMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserMapper.findAll();
    }
}
