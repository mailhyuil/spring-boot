package com.example.javamail.controller;

import com.example.javamail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String home(){
        mailService.sendMail();
        return "home";
    }
}
