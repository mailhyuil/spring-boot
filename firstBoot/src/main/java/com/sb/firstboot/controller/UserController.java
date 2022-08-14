package com.sb.firstboot.controller;

import com.sb.firstboot.domain.User;
import com.sb.firstboot.service.UserService;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String join(){
        return null;
    }

    @PostMapping("/join")
    public String join(User user){
        try {
            userService.join(user);
        } catch (DuplicateMemberException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return null;
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session){
        int ret = userService.login(user, session);
        if(ret==1) {
            System.out.println("로그인 성공!");
            return "redirect:/";
        }else{
            return "redirect:/user/login?error";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {   session.setAttribute("USER", null);
        return "redirect:/";
    }
}
