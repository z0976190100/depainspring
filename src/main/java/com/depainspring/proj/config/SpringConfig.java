package com.depainspring.proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.depainspring.proj.persistence", "com.depainspring.proj.service"})
@PropertySource("classpath:/application.properties")
public class SpringConfig {

    @Autowired
    private Environment environment;

    private String getProp(String propertyName){
        return environment.getProperty(propertyName);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getProp("DB_DRIVER_NAME"));
        dataSource.setUrl(getProp("DB_URL"));
        dataSource.setUsername(getProp("DB_LOGIN"));
        dataSource.setPassword(getProp("DB_PASS"));
        return dataSource;
    }

}
