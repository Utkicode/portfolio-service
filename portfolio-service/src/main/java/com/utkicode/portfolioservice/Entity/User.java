package com.utkicode.portfolioservice.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    private String toEmail;
    private String subject;
    private String body;
    private String name;

    public User(String toEmail, String subject, String body, String name) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
