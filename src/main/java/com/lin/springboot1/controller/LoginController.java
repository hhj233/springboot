package com.lin.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String usename, @RequestParam("password")String password,
                        Model model, HttpSession httpSession){
        if(usename!=null&&!usename.equals("")&&password.equals("123456")){
            System.out.println("===========");
            httpSession.setAttribute("loginUser", usename);
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误！");
            return "index";
        }
    }
}
