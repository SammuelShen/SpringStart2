package net.test.services;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
//@ConfigurationProperties(prefix = "demo.email")
public class SmtpService {
    @Value("demo.email.smtp")
    private String smtp;
    @Value("demo.email.port")
    private String port;

    public String  getSmtp(){
        return smtp;
    }

}

