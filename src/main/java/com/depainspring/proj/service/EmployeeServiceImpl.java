package com.depainspring.proj.service;

import com.depainspring.proj.persistence.dao.EmployeeDAO;
import com.depainspring.proj.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void saveEmployee(Employee employee) {
employeeDAO.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {

    }

    public void removeEmployee(long id) {
employeeDAO.removeEmployee(id);
    }

    public Employee getEmployeeById(long id) {
        return null;
    }

    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    public List<Employee> findAllEmployeesByDepartmentId(long departmentId) {
        return employeeDAO.findAllEmployeesByDepartmentId(departmentId);
    }
}
