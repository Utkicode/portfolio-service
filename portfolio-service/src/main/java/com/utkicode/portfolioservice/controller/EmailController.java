package com.utkicode.portfolioservice.controller;

import com.utkicode.portfolioservice.Entity.EmailRequest;
import com.utkicode.portfolioservice.Entity.User;
import com.utkicode.portfolioservice.Repository.UserRepository;
import com.utkicode.portfolioservice.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {
    @Autowired
    EmailService emailService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmailToUsers(@RequestBody EmailRequest emailRequest)
    {
        List<User> users = userRepository.findAll();
        try {
            emailService.sendEmailsToUser(users, emailRequest.getSubject(), emailRequest.getBody());
            return ResponseEntity.status(HttpStatus.OK).body("Email Sent Successfully");
        }catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service is not Available");
        }


    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(
            @RequestBody User user ) {
        try {
            emailService.sendMailByUser(user.getToEmail(), user.getSubject(), user.getBody(), user.getName());
            return ResponseEntity.status(HttpStatus.OK).body("Email sent to " + user.getToEmail() + " " + user.getName());
        }catch (Exception exception)
        {
            System.out.println(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error!");
        }

    }


}

