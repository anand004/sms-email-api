package com.trace.missingPerson.pojo;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SendSmsPojo {

    private String number;
    private String caseId;
    private String location;

    private String name;

    public SendSmsPojo() {
    }

    @Override
    public String toString() {
        return "SendSmsPojo{" +
                "number='" + number + '\'' +
                '}';
    }

    public SendSmsPojo(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendSmsPojo that = (SendSmsPojo) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
