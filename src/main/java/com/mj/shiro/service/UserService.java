package com.mj.shiro.service;


import com.mj.shiro.pojo.User;

public interface UserService {
    void save(User user);

    User selectByUsername(String username);
}
