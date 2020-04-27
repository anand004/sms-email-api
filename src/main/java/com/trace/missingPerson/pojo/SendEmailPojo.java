package com.trace.missingPerson.pojo;

import org.springframework.stereotype.Component;

@Component
public class SendEmailPojo {

    private String emailId;

    private String caseId;


    private String name;


    public SendEmailPojo() {
    }

    public SendEmailPojo(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SendEmailPojo{" +
                "emailId='" + emailId + '\'' +
                ", caseId='" + caseId + '\'' +
                '}';
    }
}
