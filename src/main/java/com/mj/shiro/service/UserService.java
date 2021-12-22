package com.mj.shiro.service;


import com.mj.shiro.pojo.Perms;
import com.mj.shiro.pojo.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User selectByUsername(String username);

    User selectRolesByUsername(String username);

    List<Perms> selectPermsByRoleId(String id);
}
