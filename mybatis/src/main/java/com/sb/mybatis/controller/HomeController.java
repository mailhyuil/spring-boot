package com.sb.mybatis.controller;

import com.sb.mybatis.model.UserVO;
import com.sb.mybatis.persistence.UserDao;
import com.sb.mybatis.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        UserVO foundUser = userService.findSB("sb");

        System.out.println(foundUser);
        return "home";
    }
}
