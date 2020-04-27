package com.trace.missingPerson.services;

import com.trace.missingPerson.pojo.SendEmailPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class SendEmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public void MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(SendEmailPojo user) throws MailException, UnsupportedEncodingException, MessagingException {

        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        InternetAddress fromAddress=new InternetAddress("no-reply@missing-child.com", "MissingPerson Support");
        SimpleMailMessage mail = new SimpleMailMessage();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new
                MimeMessageHelper(message,true);
        mimeMessageHelper.setFrom(fromAddress);
        mimeMessageHelper.setTo(user.getEmailId());
        mimeMessageHelper.setSubject("Missing Person Details");
        String msg = "<html> <head> <style> .banner-color { background-color: #eb681f; } .title-color { color: #0066cc; } .button-color { background-color: #0066cc; } @media screen and (min-width: 500px) { .banner-color { background-color: #0066cc; } .title-color { color: #eb681f; } .button-color { background-color: #eb681f; } } </style> </head> <body> <div style='background-color:#ececec;padding:0;margin:0 auto;font-weight:200;width:100%!important'> <table align='center' border='0' cellspacing='0' cellpadding='0' style='table-layout:fixed;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center'> <center style='width:100%'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='margin:0 auto;max-width:512px;font-weight:200;width:inherit;font-family:Helvetica,Arial,sans-serif' width='512'> <tbody> <tr> <td bgcolor='#F3F3F3' width='100%' style='background-color:#f3f3f3;padding:12px;border-bottom:1px solid #ececec'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;width:100%!important;font-family:Helvetica,Arial,sans-serif;min-width:100%!important' width='100%'> <tbody> <tr> <td align='left' valign='middle' width='50%'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>Case Id: "+user.getCaseId()+"</span></td> <td valign='middle' width='50%' align='right' style='padding:0 0 0 10px'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>"+formattedDate+"</span></td> <td width='1'> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' bgcolor='#8BC34A' style='padding:20px 48px;color:#ffffff' class='banner-color'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <h1 style='padding:0;margin:0;color:#ffffff;font-weight:500;font-size:20px;line-height:24px'>Missing Person Details</h1> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' style='padding:20px 0 10px 0'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%' style='padding: 0 15px;text-align: justify;color: rgb(76, 76, 76);font-size: 12px;line-height: 18px;'> <h3 style='font-weight: 600; padding: 0px; margin: 0px; font-size: 16px; line-height: 24px; text-align: center;' class='title-color'>Hi "+user.getName()+",</h3> <p style='margin: 20px 0 30px 0;font-size: 15px;text-align: center;'>Your case for missing person has been registered with case id : " +user.getCaseId()+" </b>!</p><p style='margin: 20px 0 30px 0;font-size: 12px;text-align: center;'>For any further enquiry or help kindly visit your nearest police station or call @ 100</b>!</p>  <div style='font-weight: 200; text-align: center; margin: 25px;'><a style='padding:0.6em 1em;border-radius:600px;color:#ffffff;font-size:14px;text-decoration:none;font-weight:bold' class='button-color' href='tel:100'>Call</a></div> </td> </tr> </tbody> </table> </td> </tr> <tr> </tr> <tr> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='padding:0 24px;color:#999999;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' valign='middle' width='100%' style='border-top:1px solid #d9d9d9;padding:12px 0px 20px 0px;text-align:center;color:#4c4c4c;font-weight:200;font-size:12px;line-height:18px'>Regards, <br><b>Missing Person Support</b> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' style='padding:0 0 8px 0' width='100%'></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </center> </td> </tr> </tbody> </table> </div> </body></html>";

        mimeMessageHelper.setText(msg,true);
        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(message);
    }


    public void sendEmailWithAttachment(MultipartFile file, String email, String location, String caseid,String name) throws MailException, MessagingException, UnsupportedEncodingException {
        InternetAddress fromAddress=new InternetAddress("no-reply@missing-child.com", "MissingChild Support");


        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        String imageName = file.getName().concat(".jpg");
        helper.setFrom(fromAddress);
        helper.setTo(email);
        helper.setSubject("Missing Child Details");
        //ClassPathResource classPathResource = new ClassPathResource(imageName);
        //helper.addAttachment(classPathResource.getFilename(), classPathResource);
        String location1 = "maps.google.com/maps?q=".concat(location);
        String message = "<html> <head> <style> .banner-color { background-color: #eb681f; } .title-color { color: #0066cc; } .button-color { background-color: #0066cc; } @media screen and (min-width: 500px) { .banner-color { background-color: #0066cc; } .title-color { color: #eb681f; } .button-color { background-color: #eb681f; } } </style> </head> <body> <div style='background-color:#ececec;padding:0;margin:0 auto;font-weight:200;width:100%!important'> <table align='center' border='0' cellspacing='0' cellpadding='0' style='table-layout:fixed;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center'> <center style='width:100%'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='margin:0 auto;max-width:512px;font-weight:200;width:inherit;font-family:Helvetica,Arial,sans-serif' width='512'> <tbody> <tr> <td bgcolor='#F3F3F3' width='100%' style='background-color:#f3f3f3;padding:12px;border-bottom:1px solid #ececec'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;width:100%!important;font-family:Helvetica,Arial,sans-serif;min-width:100%!important' width='100%'> <tbody> <tr> <td align='left' valign='middle' width='50%'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>Case Id: "+caseid+"</span></td> <td valign='middle' width='50%' align='right' style='padding:0 0 0 10px'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>"+formattedDate+"</span></td> <td width='1'> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' bgcolor='#8BC34A' style='padding:20px 48px;color:#ffffff' class='banner-color'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <h1 style='padding:0;margin:0;color:#ffffff;font-weight:500;font-size:20px;line-height:24px'>Missing Person Details</h1> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' style='padding:20px 0 10px 0'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%' style='padding: 0 15px;text-align: justify;color: rgb(76, 76, 76);font-size: 12px;line-height: 18px;'> <h3 style='font-weight: 600; padding: 0px; margin: 0px; font-size: 16px; line-height: 24px; text-align: center;' class='title-color'>Hi "+name+",</h3> <p style='margin: 20px 0 30px 0;font-size: 15px;text-align: center;'>The missing person with case id : " +caseid+" was last seen at the following location</b>!</p> <div style='font-weight: 200; text-align: center; margin: 25px;'><a style='padding:0.6em 1em;border-radius:600px;color:#ffffff;font-size:14px;text-decoration:none;font-weight:bold' class='button-color' href='"+location1+"'>Track</a></div> <p style='margin: 20px 0 30px 0;font-size: 12px;text-align: center;'>For more details kindly visit your nearest police station or dial 100</b>!</p> </td> </tr> </tbody> </table> </td> </tr> <tr> </tr> <tr> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='padding:0 24px;color:#999999;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' valign='middle' width='100%' style='border-top:1px solid #d9d9d9;padding:12px 0px 20px 0px;text-align:center;color:#4c4c4c;font-weight:200;font-size:12px;line-height:18px'>Regards, <br><b>Missing Person Support</b> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' style='padding:0 0 8px 0' width='100%'></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </center> </td> </tr> </tbody> </table> </div> </body></html>";

        helper.addAttachment(imageName,file);
        helper.setText(message,true);
        javaMailSender.send(mimeMessage);
    }

    public void sendCaseRegistrationEmail(MultipartFile file, String email, String location, String caseid,String name) throws MailException, MessagingException, UnsupportedEncodingException {
        InternetAddress fromAddress=new InternetAddress("no-reply@missing-child.com", "MissingChild Support");


        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        String imageName = file.getName().concat(".jpg");
        helper.setFrom(fromAddress);
        helper.setTo(email);
        helper.setSubject("Missing Child Details");
        //ClassPathResource classPathResource = new ClassPathResource(imageName);
        //helper.addAttachment(classPathResource.getFilename(), classPathResource);
        String location1 = "maps.google.com/maps?q=".concat(location);
        String message = "<html> <head> <style> .banner-color { background-color: #eb681f; } .title-color { color: #0066cc; } .button-color { background-color: #0066cc; } @media screen and (min-width: 500px) { .banner-color { background-color: #0066cc; } .title-color { color: #eb681f; } .button-color { background-color: #eb681f; } } </style> </head> <body> <div style='background-color:#ececec;padding:0;margin:0 auto;font-weight:200;width:100%!important'> <table align='center' border='0' cellspacing='0' cellpadding='0' style='table-layout:fixed;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center'> <center style='width:100%'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='margin:0 auto;max-width:512px;font-weight:200;width:inherit;font-family:Helvetica,Arial,sans-serif' width='512'> <tbody> <tr> <td bgcolor='#F3F3F3' width='100%' style='background-color:#f3f3f3;padding:12px;border-bottom:1px solid #ececec'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;width:100%!important;font-family:Helvetica,Arial,sans-serif;min-width:100%!important' width='100%'> <tbody> <tr> <td align='left' valign='middle' width='50%'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>Case Id: "+caseid+"</span></td> <td valign='middle' width='50%' align='right' style='padding:0 0 0 10px'><span style='margin:0;color:#4c4c4c;white-space:normal;display:inline-block;text-decoration:none;font-size:12px;line-height:20px'>"+formattedDate+"</span></td> <td width='1'> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' bgcolor='#8BC34A' style='padding:20px 48px;color:#ffffff' class='banner-color'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <h1 style='padding:0;margin:0;color:#ffffff;font-weight:500;font-size:20px;line-height:24px'>Missing Person Details</h1> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' style='padding:20px 0 10px 0'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%' style='padding: 0 15px;text-align: justify;color: rgb(76, 76, 76);font-size: 12px;line-height: 18px;'> <h3 style='font-weight: 600; padding: 0px; margin: 0px; font-size: 16px; line-height: 24px; text-align: center;' class='title-color'>Hi "+name+",</h3> <p style='margin: 20px 0 30px 0;font-size: 15px;text-align: center;'>Your case for missing person has been registered with case id : " +caseid+" </b>!</p><p style='margin: 20px 0 30px 0;font-size: 12px;text-align: center;'>For any further enquiry or help kindly visit your nearest police station or call @ 100</b>!</p>  <div style='font-weight: 200; text-align: center; margin: 25px;'><a style='padding:0.6em 1em;border-radius:600px;color:#ffffff;font-size:14px;text-decoration:none;font-weight:bold' class='button-color' href='tel:100'>Call</a></div> </td> </tr> </tbody> </table> </td> </tr> <tr> </tr> <tr> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='left'> <table bgcolor='#FFFFFF' border='0' cellspacing='0' cellpadding='0' style='padding:0 24px;color:#999999;font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' valign='middle' width='100%' style='border-top:1px solid #d9d9d9;padding:12px 0px 20px 0px;text-align:center;color:#4c4c4c;font-weight:200;font-size:12px;line-height:18px'>Regards, <br><b>Missing Person Support</b> </td> </tr> </tbody> </table> </td> </tr> <tr> <td align='center' width='100%'> <table border='0' cellspacing='0' cellpadding='0' style='font-weight:200;font-family:Helvetica,Arial,sans-serif' width='100%'> <tbody> <tr> <td align='center' style='padding:0 0 8px 0' width='100%'></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </center> </td> </tr> </tbody> </table> </div> </body></html>";

        helper.addAttachment(imageName,file);
        helper.setText(message,true);
        javaMailSender.send(mimeMessage);
    }

}



