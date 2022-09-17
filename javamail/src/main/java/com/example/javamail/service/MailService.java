package com.example.javamail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(){
        ArrayList<String> toUserList = new ArrayList<>();

        toUserList.add("mailhyuil@gmail.com");

        int toUserSize = toUserList.size();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));

        simpleMailMessage.setSubject("안녕하세요");

        simpleMailMessage.setText("반갑습니다");

        javaMailSender.send(simpleMailMessage);
    }
}
