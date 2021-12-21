package com.mj.shiro.realm;

import com.mj.shiro.dao.UserDao;
import com.mj.shiro.pojo.User;
import com.mj.shiro.service.UserService;
import com.mj.shiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/20 21:36:52
 */
public class CustomerRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user = userService.selectByUsername(principal);
        if (!ObjectUtils.isEmpty(user)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
