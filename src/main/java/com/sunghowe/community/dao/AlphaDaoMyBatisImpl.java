package com.sunghowe.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author SungHowe
 * @title AlphaDaoMyBatisImpl
 * @description
 * @create 2022-05-16 19:51
 */
@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
