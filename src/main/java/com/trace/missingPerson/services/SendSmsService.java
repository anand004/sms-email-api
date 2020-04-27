package com.trace.missingPerson.services;

import com.trace.missingPerson.pojo.SendSmsPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class SendSmsService {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsService.class);


    public static String sendSms(SendSmsPojo sendSmsPojo) {
            try {
                // Construct data

                String apiKey = "apikey=" + "Ck2Dt5Y1gbg-3jTTrGPtofGUSDUGHHyb1ruaDZ2zSd";
                String message = "&message=" + "Hi "+sendSmsPojo.getName()+", the missing person with case id: "+sendSmsPojo.getCaseId()+"  was last seen at the following location: https://maps.google.com/maps?q="+sendSmsPojo.getLocation()+" .For further details contact your nearest police station or dial 100.";
                String sender = "&sender=" + "TXTLCL";
                String numbers = "&numbers=" + sendSmsPojo.getNumber();
                logger.info(numbers);
                // Send data
                logger.info("Sending Message");
                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                String data = apiKey + numbers + message + sender;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();

                return stringBuffer.toString();
            } catch (Exception e) {
                System.out.println("Error SMS "+e);
                return "Error "+e;
            }
        }
    public String getGroups() {
        try {
            // Construct data
            String apiKey = "apikey=" + "Ck2Dt5Y1gbg-3jTTrGPtofGUSDUGHHyb1ruaDZ2zSd";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/get_sender_names/?").openConnection();
            String data = apiKey;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
    public static String sendCaseRegistrationSms(SendSmsPojo sendSmsPojo) {
        try {
            // Construct data

            String apiKey = "apikey=" + "Ck2Dt5Y1gbg-3jTTrGPtofGUSDUGHHyb1ruaDZ2zSd";
            String message = "&message=" + "Hi "+sendSmsPojo.getName()+", Your case for missing person has been registered with case id: "+sendSmsPojo.getCaseId()+" .For any enquiry or help kindly visit your nearest police station or dial 100.";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + sendSmsPojo.getNumber();
            logger.info(numbers);
            // Send data
            logger.info("Sending Message");
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }


    }

