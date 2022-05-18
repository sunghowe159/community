package com.sunghowe.community.dao;

import com.sunghowe.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SungHowe
 * @title UserMapper
 * @description
 * @create 2022-05-17 14:58
 */
@Mapper
public interface UserMapper {
    User selectById(Integer id);
    User selectByName(String username);
    User selectByEmail(String email);

    Integer insertUser(User user);
    Integer updateStatus(Integer id, Integer status);
    Integer updateHeader(Integer id, String headerUrl);
    Integer updatePassword(Integer id, String password);
}
