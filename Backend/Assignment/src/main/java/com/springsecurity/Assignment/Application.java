package com.springsecurity.Assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.springsecurity.Assignment")
@EnableAutoConfiguration
@Configuration
@RequestMapping(value = "/")
@EnableScheduling
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(Application.class,args);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }
}
