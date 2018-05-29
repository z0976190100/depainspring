package com.depainspring.proj.config;

import com.depainspring.proj.service.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.depainspring.proj.persistence", "com.depainspring.proj.service"})
@PropertySource("classpath:/messages.properties")
public class SpringConfig {

    @Autowired
    public Environment environment;



    @Bean
//    @Bean(name = "temp")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/Departments?currentSchema=department1");
        dataSource.setUsername("postgres");
        dataSource.setPassword("rut");
        return dataSource;
    }

   /* @Bean*//*(name = "ddao")*//*
    public DepartmentDAO getDepartmentDAO() {
        return new DepartmentDAOImpl();
    }

    @Bean
    *//*@Bean(name = "dser")*//*
    public DepartmentService getDepartmentService() {
        return new DepartmentServiceImpl();
    }

    @Bean
    *//*@Bean(name = "edao")*//*
    public EmployeeDAO getEmployeeDAO(){
        return new EmployeeDAOImpl(getJdbcTemplate());
    }

    @Bean
//    @Bean(name = "eser")
    public EmployeeService getEmployeeService(){
        return new EmployeeServiceImpl();
    }

    @Bean
//    @Bean(name = "dmap")
    public DepartmentMapper getDepartmentMapperImpl(){
        return new DepartmentMapperImpl();
    }
*/
}
