package com.depainspring.proj.service;

import com.depainspring.proj.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void removeEmployee(long id);
    Employee getEmployeeById(long id);
    List<Employee> findAllEmployees();
    List<Employee> findAllEmployeesByDepartmentId(long departmentId);
}
