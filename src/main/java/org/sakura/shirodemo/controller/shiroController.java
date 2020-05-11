package org.sakura.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.sakura.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class shiroController {

    @Autowired
    UserService userService;



    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","Hello!");
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String login(String name, String password,Model model){
        //登录验证简单逻辑
//        if (userService.login(name,password)) {
//            return "index";
//        }
//        return "login";
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            model.addAttribute("msg","Hello ");
            model.addAttribute("name",name);
            return "index";
        }
//        catch (IncorrectCredentialsException ae){
//            return "密码不正确";
//        }
        catch (AuthenticationException e){
//            return "用户名或密码错误";
            return "login";
        }
//        if (subject.isAuthenticated()){
//            return "登录成功";
//        } else {
//            token.clear();
//            return "登录失败";
//        }
    }

    @GetMapping("/add")
    public String add(){
        return "/user/add";
    }
    @GetMapping("/update")
    public String update(){
        return "/user/update";
    }

    @GetMapping("/test")
    @ResponseBody
    public void test(){
        userService.selectList();
    }
}
