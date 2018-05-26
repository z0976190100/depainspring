package com.depainspring.proj.controller;

import com.depainspring.proj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getListEmployees(@PathVariable("id") long id, Map<String, Object> model) {
        model.put("employeesList", service.findAllEmployeesByDepartmentId(id));
        return "employees_list";
    }

}
