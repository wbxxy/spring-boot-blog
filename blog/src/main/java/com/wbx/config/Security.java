package com.wbx.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author:   wbx
 * @email:    wbx123450@163.com
 * @date:     2019/5/15-23:20
 * @module:   []
 * @describe: [Security extends WebSecurityConfigurerAdapter
 *              1. configure(HttpSecurity http) 校验请求, 并设置过滤和转发
 *              2. AuthenticationProvider authenticationProvider 获得用户校验信息
 *              3. auth.authenticationProvider(authenticationProvider)
 *              4. 从而实现从数据库查询
 *              ]
 * @version:  v1.0
 */
@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()
                .antMatchers("/users/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").failureForwardUrl("/login-error");
    }


    @Bean
    MyAuthenticationProvider getAuthenticationProvider(){
        return new MyAuthenticationProvider();
    }
    @Autowired
    AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
