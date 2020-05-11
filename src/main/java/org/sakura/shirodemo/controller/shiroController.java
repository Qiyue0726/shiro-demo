package org.sakura.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.sakura.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class shiroController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String login(String name, String password){
        //登录验证简单逻辑
//        if (userService.login(name,password)) {
//            return "index";
//        }
//        return "login";

        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();

//        subject.login(token);
//        return "登录成功";
        try {

            subject.login(token);
            return "index";
        }catch (AuthenticationException e){
            return "login";
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public void test(){
        userService.selectList();
    }
}
