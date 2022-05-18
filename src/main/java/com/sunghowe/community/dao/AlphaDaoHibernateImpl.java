package com.sunghowe.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author SungHowe
 * @title AlphaDaoHibernateImpl
 * @description
 * @create 2022-05-16 19:48
 */
@Repository("alphaDaoHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
