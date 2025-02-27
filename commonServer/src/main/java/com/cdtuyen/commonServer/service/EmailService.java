package com.cdtuyen.commonServer.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final Configuration configuration;
    public void sendEmail(String to, String subject, String text, boolean isHtml, File attachment){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);

            // add attachment file
            if (attachment != null){
                FileSystemResource fileSystemResource = new FileSystemResource(attachment);
                helper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
            }
            javaMailSender.send(message);
            log.info("Email send success to", to);
        }catch (MessagingException e){
            log.error("Failed to send email to{}",to,e);
        }
    }
    public void sendEmailTemplate(String to, String subject, String templateName, Map<String, Object> placeholders, File attachment){
        try {
            Template t = configuration.getTemplate(templateName);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, placeholders);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
            // add attachment file
            if (attachment != null){
                FileSystemResource fileSystemResource = new FileSystemResource(attachment);
                helper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
            }
            javaMailSender.send(message);
            log.info("Email send success to", to);
        }catch (MessagingException | IOException | TemplateException e){
            log.error("Failed to send email to{}",to,e);
        }
    }
}
