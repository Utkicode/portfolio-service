package com.utkicode.portfolioservice.service;


import com.utkicode.portfolioservice.Entity.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendEmailsToUser(List<User> userList, String subject, String body)
    {
        for(User user : userList)
        {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            try{
                mimeMessageHelper.setTo(user.getToEmail());
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(body, true);
                javaMailSender.send(mimeMessage);

            }catch ( MessagingException messagingException)
            {
                messagingException.printStackTrace();
            }
        }

    }
    public void sendMailByUser(String toEmail, String subject, String body, String name)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject(subject);
            //mimeMessageHelper.setText(body, true);
            String emailBody = "Dear " + name + ",\n\n" + body;
            mimeMessageHelper.setText(emailBody, true);
            javaMailSender.send(mimeMessage);

        }catch ( MessagingException messagingException)
        {
            System.out.println(messagingException.getMessage());
        }
    }
}

