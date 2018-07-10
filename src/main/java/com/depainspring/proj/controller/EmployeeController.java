package com.depainspring.proj.controller;

import com.depainspring.proj.persistence.entity.Employee;
import com.depainspring.proj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees/{departmentId}")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String getListEmployees(@PathVariable(name = "departmentId") long departmentId,
                                   Map<String, Object> model) {
        List<Employee> employeesByDepartmentId = service.findAllEmployeesByDepartmentId(departmentId);
        model.put("employeesList", employeesByDepartmentId);
        return "employees_list";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") long id, Map<String, Object> model) {
        model.put("employee", service.getEmployeeById(id));
        return "employee_form";
    }

    @GetMapping("/add_form")
    public String getEmployeeAddForm(@PathVariable(name = "departmentId") long departmentId, Map<String, Object> model) {
        model.put("departmentId", departmentId);
        model.put("newEmployee", new Employee());
        return "employee_add_page";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute Employee newEmployee, Map<String, Object> model) { //@RequestParam("departmentId") long departmentId
        service.saveEmployee(newEmployee);
        long departmentId = newEmployee.getDepartment();
        List<Employee> employeesByDepartmentId = service.findAllEmployeesByDepartmentId(departmentId);
        model.put("employeesList", employeesByDepartmentId);
        return "employees_list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(Map<String, Object> model,
                                 @PathVariable(name = "departmentId") long departmentId,
                                 @PathVariable(name = "id") long id) {
        service.removeEmployee(id);
        //long

        return "redirect:/employees/{departmentId}";
    }

   /* @PostMapping("/edit/{id}")
    public String editEmployee(@RequestParam("departmentId") long departmentId,
                               @PathVariable("id") long id,
                               Map<String, Object> model) {
        Employee employee = service.getEmployeeById(id);
        service.updateEmployee(employee);
        model.put("employeesList", service.findAllEmployeesByDepartmentId(departmentId));
        return "employees_list";
    }*/

}
