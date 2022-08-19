package com.sb.firstboot.controller;

import com.sb.firstboot.repository.UserDao;
import com.sb.firstboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @GetMapping("/")
    public String home(){

        System.out.println(userService.findById("sb"));
        return "home";
    }

}
