package org.sakura.shirodemo.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<>();
        map.put("/","anon");
        map.put("/login","anon");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setLoginUrl("/");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(UserReaml userReaml){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userReaml);
        return securityManager;
    }


    @Bean
    public UserReaml getUserReaml(){
        return new UserReaml();
    }
}
