package org.sakura.shirodemo.config;

import com.mysql.cj.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.sakura.shirodemo.entiry.UserEntity;
import org.sakura.shirodemo.service.RoleService;
import org.sakura.shirodemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserReaml extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("------------------开始授权-----------------");

        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        UserEntity userEntity = null;
        if (!StringUtils.isNullOrEmpty(String.valueOf(principal))){
            userEntity = new UserEntity();
            BeanUtils.copyProperties(principal,userEntity);
        }

        Set<String> roleSet = new HashSet<>();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        if ("admin".equals(roleService.select(userEntity))){
            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addStringPermission("*:*");
        }
        return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("----------------开始认证--------------------");
        if (authenticationToken.getPrincipal() == null){
            return null;
        }
        String name = authenticationToken.getPrincipal().toString();
        UserEntity userEntity = userService.getUser(name);
        if (userEntity == null){
            return null;
        }else {
            // SimpleAuthenticationInfo 中直接放 user 对象，便于授权时获取其它信息，通过 subject.getPrincipal() 获取该对象
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
