package com.depainspring.proj.persistence.dao;

import com.depainspring.proj.persistence.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void removeEmployee(long id);
    Employee getEmployeeById(long id);
    List<Employee> findAllEmployees();
    List<Employee> findAllEmployeesByDepartmentId(long departmentId);
}


   /* void saveDepartment(Department department);
    void updateDepartment(Department department);
    void removeDepartment(long id);
    Department getDepartmentById(long id);
    List<Department> findAllDepartments();*/