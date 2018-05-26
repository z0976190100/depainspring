package com.depainspring.proj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.depainspring.proj.persistence", "com.depainspring.proj.service"})
public class SpringConfig {


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
