package com.example.controller;

import com.example.entity.iUser;
import com.example.service.iUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class iUserController {

    @Autowired
    private iUserService service;

    @PostMapping("login")
    public String login(String username, String password, HttpSession session, Model model) {

        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //设置记住我
        //token.setRememberMe(true);
        try {
            subject.login(token);
            iUser userDB = service.login(username, password);
            session.setAttribute("userDB",userDB);
            return "redirect:/files/findAll";
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg","用户名不存在");
            return "redirect:/index";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "redirect:/index";
        }



    }
}
