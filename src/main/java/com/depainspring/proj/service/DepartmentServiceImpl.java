package com.depainspring.proj.service;

import com.depainspring.proj.persistence.dao.DepartmentDAO;
import com.depainspring.proj.persistence.entity.Department;
import com.depainspring.proj.service.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    //TODO how should i get DEPARTMENT?

    private DepartmentDAO departmentDAO;
    private Department department;
//    private DepartmentDto departmentDto;

    @Autowired
    public DepartmentServiceImpl(DepartmentDAO dao) {
        this.departmentDAO = dao;
//        this.departmentDto = dto;
    }


    private void setDepartment(long id, String title) {
        this.department = new Department();
        department.setId(id);
        department.setTitle(title);
    }

    private void setDepartment(String title) {
        this.department = new Department();
        department.setTitle(title);
    }

    private Department getDepartment() {
        return this.department;
    }

    public void saveDepartment(String title) {
        setDepartment(title);
        departmentDAO.saveDepartment(getDepartment());

    }

    public void updateDepartment(long id, String title) {
        Department department = getDepartmentById(id);
        department.setTitle(title);
        departmentDAO.updateDepartment(department);

    }

    public void removeDepartment(long id) {
        departmentDAO.removeDepartment(id);
    }

    public Department getDepartmentById(long id) {
        return departmentDAO.getDepartmentById(id);
    }

    public List<Department> findAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    public int getEmployeeNumberByDepartment(Department department) {
        return departmentDAO.getEmployeeNumberByDepartment(department);
    }

    @Override
    public List<DepartmentDto> getDepartmentDtoList() {
        List<Department> allDepartments = departmentDAO.findAllDepartments();
        List<DepartmentDto> allDepartmentsDto = new ArrayList<>();
        for (Department department : allDepartments) {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setId(department.getId());
            departmentDto.setTitle(department.getTitle());
            int employeeNumber = departmentDAO.getEmployeeNumberByDepartment(department);
            departmentDto.setEmployeeNumber(employeeNumber);
            allDepartmentsDto.add(departmentDto);
        }
        return allDepartmentsDto;
    }
}
