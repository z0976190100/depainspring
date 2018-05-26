package com.depainspring.proj.service.dto;

import org.springframework.stereotype.Component;

@Component
public class DepartmentDto {

    private long id;
    private String title;
    private int employeeNumber;

    public DepartmentDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
