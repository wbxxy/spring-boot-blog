package com.wbx.config;

import com.wbx.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author:   wbx
 * @email:    wbx123450@163.com
 * @date:     2019/5/15-23:22
 * @module:   []
 * @describe: [UserDetailsService
 *              1. loadUserByUsername(String username)
 *              2. 从数据库查询]
 * @version:  v1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==============");
        return iUserInfoService.getUserInfo(username);
    }
}