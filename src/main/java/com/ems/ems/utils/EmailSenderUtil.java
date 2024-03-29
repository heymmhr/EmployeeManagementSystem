package com.ems.ems.utils;

import com.ems.ems.dto.EmailDto;
import org.apache.commons.mail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Component
public class EmailSenderUtil {

    @Autowired
    private FileStorageUtils fileStorageUtils;

    public String sendEmail(EmailDto emailDto){
        try{

            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthentication("hemanmaharjan.075@kathford.edu.np","Heman.kathford123");
            email.setSSLOnConnect(true);
            email.setFrom("popexab940@dovesilo.com");
            email.setSubject(emailDto.getSubject());
            email.setMsg(emailDto.getMessage() );
            email.addTo(emailDto.getReceiver());
            email.send();
            return ("Email sent successfully");
        }catch (Exception ex){
            ex.printStackTrace();
            return ("Failed to send email");
        }
    }

    public String sendEmailWithAttachment(EmailDto emailDto){
        try {

            MultipartFile multipartFile = emailDto.getImage();
            String storedFilePath = fileStorageUtils .storeFile(multipartFile);

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(storedFilePath);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Sample Image");
            attachment.setName(multipartFile.getOriginalFilename());

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthentication("hemanmaharjan.075@kathford.edu.np","Heman.kathford123");
            email.setSSLOnConnect(true);
            email.setFrom("popexab940@dovesilo.com");
            email.setSubject(emailDto.getSubject());
            email.setMsg(emailDto.getMessage() );
            email.addTo(emailDto.getReceiver());

            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
            Files.delete(new File(storedFilePath).toPath());

            return "Email sent successfully!!";
        }catch (Exception ex){
            return "Email sending failed !!";
        }
    }
}
