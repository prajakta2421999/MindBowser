package com.springsecurity.Assignment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        AuthorizationInterceptor authorizationInterceptor = new AuthorizationInterceptor();
        List<String> bypassUrlList = new ArrayList<>(1);
        bypassUrlList.add("/v2/register");
        bypassUrlList.add("/v2/login");
        bypassUrlList.add("/v2/getAllEmployeeByFirstNameAndLastName");
        bypassUrlList.add("/v2/registerEmployee");
        bypassUrlList.add("/v2/editEmp");
        bypassUrlList.add("/v2/deleteEmp");
        bypassUrlList.add("/v2/updateEmp");
        authorizationInterceptor.setBypassUrlList(bypassUrlList);
        authorizationInterceptor.setSessionHandler(sessionHandler());
        return authorizationInterceptor;
    }

    @Bean
    public SessionHandler sessionHandler(){
        return new SessionHandler();
    }
}
