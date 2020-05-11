package org.sakura.shirodemo.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.sakura.shirodemo.entiry.UserEntity;
import org.sakura.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserReaml extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null){
            return null;
        }
        String name = authenticationToken.getPrincipal().toString();
        UserEntity userEntity = userService.getUser(name);
        if (userEntity == null){
            return null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,userEntity.getPassword(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
