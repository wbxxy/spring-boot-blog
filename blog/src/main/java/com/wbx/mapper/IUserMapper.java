package com.wbx.mapper;


import com.wbx.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserMapper {
    public User findById(int id);

    public List<User> findAll();
}
