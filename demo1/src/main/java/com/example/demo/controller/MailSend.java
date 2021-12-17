package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.MessagingException;
import java.util.ArrayList;
import com.example.demo.bean.Email;

@RestController
@RequestMapping("/mail")
public class MailSend {
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @PostMapping("/sendemail")
    public void sendMail(@RequestBody Email x){
        System.out.println("这是发信人信息："+username);
        System.out.println("这是邮件相关信息：");
        System.out.println(x.address+"  "+x.title+"  "+x.body);
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(x.address);
        message.setSubject(x.title);
        message.setText(x.body);
        javaMailSender.send(message);
    }
}
