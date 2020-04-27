package com.trace.missingPerson.controller;

import com.trace.missingPerson.pojo.SendSmsPojo;
import com.trace.missingPerson.services.SendSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SendSmsController {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsService.class);


    @Autowired
    private SendSmsService sendSmsService;

    @Autowired
    private SendSmsPojo sendSmsPojo;

    @PostMapping(path = "send-sms")
    public String sendSms(@RequestBody SendSmsPojo sendSmsPojo){
        String s = sendSmsService.sendSms(sendSmsPojo);
        logger.info("The Response is "+s);
        return s;
    }

    @PostMapping(path = "get-sender-names")
    public String getSender(){
        return sendSmsService.getGroups();
    }

    @PostMapping(path = "send-registration-sms")
    public String sendRegistrationSms(@RequestBody SendSmsPojo sendSmsPojo){
        String s = sendSmsService.sendCaseRegistrationSms(sendSmsPojo);
        logger.info("The Response is "+s);
        return s;
    }
}
