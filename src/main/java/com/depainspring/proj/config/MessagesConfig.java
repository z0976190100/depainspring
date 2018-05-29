package com.depainspring.proj.config;

import com.depainspring.proj.service.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.depainspring.proj.service"})
@PropertySource("classpath:/messages.properties")
public class MessagesConfig {

    @Autowired
    private Environment environment;

    @Bean
    public MessageManager messageManager(){

        return new MessageManager(this.environment);
    }

    /*@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
