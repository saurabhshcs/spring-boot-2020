package com.techsharezone.springbootemailsender;

import com.techsharezone.springbootemailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringBootEmailSenderApplication {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailSenderApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerEmail() throws MessagingException {
        emailService.sendSimpleEmail("saurabhshcs@yahoo.com", "This is an email from the spring-boot application",
                "Hello from the spring-boot mail example");

        emailService.sendAttachmentEmail("saurabhshcs@yahoo.com", "This is an email from the spring-boot application with sample attachement",
                "Hello from the spring-boot mail attachment example", "/Users/saurabhshcs/Desktop/myBike.jpg");
    }

}
