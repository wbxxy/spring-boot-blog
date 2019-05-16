package com.wbx.mapper;

import com.wbx.domain.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserInfoMapper {
    public UserInfo getUserInfo(String username);
}
