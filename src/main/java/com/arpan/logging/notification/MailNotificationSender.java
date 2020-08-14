package com.arpan.logging.notification;

import java.io.File;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailNotificationSender implements NotificationSender{
    
    @Override
    public void sendNotification(Notification notification) {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        // TODO - set creds
        String username = "e668a23daba565";
        String password = "4cf4f79e3f9ab0";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            System.out.println("Sending email.......");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(notification.getFromAddress()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(notification.getToAddress()));
            message.setSubject(notification.getSubject());

            String msg = notification.getMessage();

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(notification.getAttachment());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Mail Sent!");
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("Mail not sent!");
        }

        
    }
}