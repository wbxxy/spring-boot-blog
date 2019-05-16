package com.wbx.config;


import com.wbx.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author:   wbx
 * @email:    wbx123450@163.com
 * @date:     2019/5/15-23:15
 * @module:   []
 * @describe: [ authentication获取前端输入的密码
 *              1. authentication.getName()
 *              2. authentication.getCredentials()
 *              3. userDetailService.loadUserByUsername(userName)
 *              4. userInfo.getAuthorities()
 *              5. UsernamePasswordAuthenticationToken(userInfo, password, authorities)
 *            ]
 * @version:  v1.0
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；

        System.out.println("------------------");

        UserInfo userInfo = (UserInfo) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        System.out.println(userInfo.toString());

        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        if (!userInfo.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }

        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities); // 构建返回的用户登录成功的token
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
