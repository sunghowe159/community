package com.sunghowe.community.service;

import com.sunghowe.community.dao.UserMapper;
import com.sunghowe.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SungHowe
 * @title UserService
 * @description
 * @create 2022-05-17 19:47
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
