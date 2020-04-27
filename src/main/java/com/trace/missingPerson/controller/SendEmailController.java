package com.trace.missingPerson.controller;

import com.trace.missingPerson.pojo.SendEmailPojo;
import com.trace.missingPerson.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;


    @PostMapping("send-mail")
    public String send(@RequestBody SendEmailPojo user) {

        try {
            sendEmailService.sendEmail(user);
        } catch (MailException | UnsupportedEncodingException | MessagingException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }


    @RequestMapping(value = "send-mail-attachment",method = RequestMethod.POST)
    public ResponseEntity sendWithAttachment(@RequestParam(name = "file" ) MultipartFile file, @RequestParam(value = "email") String email, @RequestParam("location") String location, @RequestParam("caseid") String caseid, @RequestParam("name") String name){

        try {
            System.out.println("Inside Controller");
            //MultipartFile file = null;
            sendEmailService.sendEmailWithAttachment(file,email,location,caseid,name);
            return new ResponseEntity("Congratulations! Your mail has been send to the user.", HttpStatus.OK);
        } catch (Exception mailException) {
            System.out.println(mailException);
        }
        return new ResponseEntity("Some error occurred. ", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "case-registration-email",method = RequestMethod.POST)
    public ResponseEntity sendCaseRegisteredEmail(@RequestParam(name = "file" ) MultipartFile file, @RequestParam(value = "email") String email, @RequestParam("location") String location, @RequestParam("caseid") String caseid, @RequestParam("name") String name){

        try {
            System.out.println("Inside Controller");
            //MultipartFile file = null;
            sendEmailService.sendCaseRegistrationEmail(file,email,location,caseid,name);
            return new ResponseEntity("Congratulations! Your mail has been send to the user.", HttpStatus.OK);
        } catch (Exception mailException) {
            System.out.println(mailException);
        }
        return new ResponseEntity("Some error occurred. ", HttpStatus.BAD_REQUEST);
    }
}

