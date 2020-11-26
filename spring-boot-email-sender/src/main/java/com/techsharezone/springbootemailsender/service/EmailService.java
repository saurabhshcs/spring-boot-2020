package com.techsharezone.springbootemailsender.service;

/*
 * @created 26/11/2020 -01:42
 * @project spring-boot-email-sender
 * @author  saurabhshcs
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(final String to, final String subject, final String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

        LOG.info("The email has been sent to {}", to);
    }

    public void sendAttachmentEmail(final String to, final String subject, final String message, final String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);

        FileSystemResource resource = new FileSystemResource(new File(attachment));

        messageHelper.addAttachment(resource.getFilename(), resource);

        mailSender.send(mimeMessage);

        LOG.info("The email has been sent to {} with the attachment [{}]", to, resource.getPath());
    }
}
