package org.sakura.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String password, Model model){

        //登录验证简单逻辑
//        if (userService.login(name,password)) {
//            return "index";
//        }
//        return "login";

        // shiro 登录认证
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            model.addAttribute("msg","Hello ");
            model.addAttribute("name",name);
            model.addAttribute("logout","true");
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg1","未知账户");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg1","密码不正确");
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg1","账户已锁定");
            return "login";
        } catch (ExcessiveAttemptsException eae) {
            model.addAttribute("msg1","用户名或密码错误次数过多");
            return "login";
        } catch (AuthenticationException ae) {
            model.addAttribute("msg1","用户名或密码不正确！");
            return "login";
        }
    }

    @GetMapping("/add")
    @RequiresPermissions("user:add")
    public String add(){
        return "/user/add";
    }

    @RequiresPermissions("user:update")
    @GetMapping("/update")
    public String update(){
        return "/user/update";
    }

    @GetMapping("/delete")
    @RequiresRoles("admin")
    public String delete(){
        return "/user/delete";
    }

    @GetMapping("/select")
    public String select(){
        return "/user/select";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(Model model){
        return "已退出系统";
    }

    @GetMapping("/test")
    @ResponseBody
    public void test(){
        userService.selectList();
    }
}
