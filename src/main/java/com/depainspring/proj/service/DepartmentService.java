package com.depainspring.proj.service;

import com.depainspring.proj.persistence.entity.Department;
import com.depainspring.proj.service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    //    void saveDepartment(Department department);
    void saveDepartment(String title);

    void updateDepartment(Department department);

    void removeDepartment(long id);

    Department getDepartmentById(long id);

    List<Department> findAllDepartments();

    int getEmployeeNumberByDepartment(Department department);

    List<DepartmentDto> getDepartmentDtoList();
}
