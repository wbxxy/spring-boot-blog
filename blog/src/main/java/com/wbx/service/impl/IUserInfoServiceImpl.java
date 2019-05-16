package com.wbx.service.impl;

import com.wbx.domain.UserInfo;
import com.wbx.mapper.IUserInfoMapper;
import com.wbx.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IUserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private IUserInfoMapper iUserInfoMapper;

    @Override
    public UserInfo getUserInfo(String username) {
        return iUserInfoMapper.getUserInfo(username);
    }
}
