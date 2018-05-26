package com.depainspring.proj.persistence.dao;

import com.depainspring.proj.persistence.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    void saveDepartment(Department department);
//    void saveDepartment(DepartmentDto department);
    void updateDepartment(Department department);
    void removeDepartment(long id);
    Department getDepartmentById(long id);
    List<Department> findAllDepartments();
    int getEmployeeNumberByDepartment(Department department);
}


