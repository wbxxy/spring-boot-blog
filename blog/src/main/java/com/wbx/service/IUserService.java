package com.wbx.service;

import com.wbx.domain.User;

import java.util.List;

public interface IUserService {

    public User findById(int id);

    public List<User> findAll();
}
