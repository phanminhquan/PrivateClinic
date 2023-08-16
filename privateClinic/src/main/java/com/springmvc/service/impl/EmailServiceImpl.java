package com.springmvc.service.impl;

import com.springmvc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
   private JavaMailSenderImpl javaMailSender;
    @Override
    public void sendMail(String username,String email, String result) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Xác nhận lịch khám");
        newEmail.setText("Xin chào " + username +"\nThông báo về việc lịch hẹn của bạn đã được xác nhận thành công");
        javaMailSender.send(newEmail);
    }
}
