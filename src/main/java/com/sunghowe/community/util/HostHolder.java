package com.sunghowe.community.util;

import com.sunghowe.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author SungHowe
 * @title HostHolder
 * @description 持有用户信息，用于代替session对象
 * @create 2022-05-22 15:11
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUsers(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
