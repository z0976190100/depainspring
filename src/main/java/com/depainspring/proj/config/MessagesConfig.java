package com.depainspring.proj.config;

import com.depainspring.proj.service.util.MessageManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.depainspring.proj.service"})
@PropertySource("classpath:/messages.properties")
public class MessagesConfig {

    @Value("${hui}")
    private String hui;
    @Value("${SERVLET_EXCEPTION_ERROR_MESSAGE}")
    private String SERVLET_EXCEPTION_ERROR_MESSAGE;
    @Value("${IO_EXCEPTION_ERROR_MESSAGE}")
    private String IO_EXCEPTION_ERROR_MESSAGE;
    /*@Value("${}") private String LOGIN_SAVE_PROBLEM_MESSAGE = "LOGIN_SAVE_PROBLEM_MESSAGE";
    @Value("${}") private String LOGIN_PASSWORD_PROBLEM_MESSAGE = "LOGIN_PASSWORD_PROBLEM_MESSAGE";
    @Value("${}") private String DEPTITLE_SAVE_PROBLEM_MESSAGE = "DEPTITLE_SAVE_PROBLEM_MESSAGE";
    @Value("${}") private String EMPTY_FIELD_MESSAGE = "EMPTY_FIELD_MESSAGE";
    @Value("${}") private String INVALID_EMAIL_MESSAGE = "INVALID_EMAIL_MESSAGE";
    @Value("${}") private String FAILED_PASS_CONFIRMATION_MESSAGE = "FAILED_PASS_CONFIRMATION_MESSAGE";
    @Value("${}") private String INVALID_DATE_MESSAGE = "INVALID_DATE_MESSAGE";
    @Value("${}") private String NEW_EMPLOYEE_SAVE_SUCCESS_MESSAGE = "NEW_EMPLOYEE_SAVE_SUCCESS_MESSAGE";
    @Value("${}") private String EMPLOYEE_RECORD_UPDATE_SUCCESS_MESSAGE = "EMPLOYEE_RECORD_UPDATE_SUCCESS_MESSAGE";
    @Value("${}") private String NEW_DEP_SAVE_SUCCESS_MESSAGE = "NEW_DEP_SAVE_SUCCESS_MESSAGE";*/
    @Value("${DEP_RECORD_UPDATE_SUCCESS_MESSAGE}") private String DEP_RECORD_UPDATE_SUCCESS_MESSAGE;

    @Bean
    public MessageManager messageManager(){

        MessageManager messageManager = new MessageManager();

        messageManager.setDEP_RECORD_UPDATE_SUCCESS_MESSAGE(DEP_RECORD_UPDATE_SUCCESS_MESSAGE);

        return messageManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
