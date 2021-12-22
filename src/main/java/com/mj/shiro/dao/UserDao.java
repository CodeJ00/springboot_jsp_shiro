package com.mj.shiro.dao;

import com.mj.shiro.pojo.Perms;
import com.mj.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 13:03:42
 */
@Mapper
public interface UserDao {
    void save(User user);

    User selectByUsername(String username);

    User selectRolesByUsername(String username);

    List<Perms> selectPermsByRoleId(String id);
}
