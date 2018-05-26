package com.depainspring.proj.persistence.mapper;

import com.depainspring.proj.persistence.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapperImpl implements EmployeeMapper{

    public Employee mapRow(ResultSet resultSet, int id) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setBirthDate(resultSet.getDate("birth_date"));
        employee.setDepartment(resultSet.getLong("department_id_long"));
        employee.setLogin(resultSet.getString("login"));
        employee.setPass(resultSet.getString("pass"));
        employee.setPass2(resultSet.getString("pass2"));
        return employee;
    }
}
