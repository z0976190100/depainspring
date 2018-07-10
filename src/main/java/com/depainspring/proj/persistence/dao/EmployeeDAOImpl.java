package com.depainspring.proj.persistence.dao;

import com.depainspring.proj.persistence.entity.Employee;
import com.depainspring.proj.persistence.mapper.EmployeeMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee2 (first_name, last_name, department_id_long, login, pass, birth_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getLogin(),
                employee.getPass(),
                employee.getBirthDate());

    }

    public void updateEmployee(Employee employee) {

    }

    public void removeEmployee(long id) {
        String sql = "DELETE FROM employee2 WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Employee getEmployeeById(long id) {
        return null;
    }

    public List<Employee> findAllEmployees() {
        String sql = "SELECT * FROM employee2";
        return jdbcTemplate.query(sql, new EmployeeMapperImpl());
    }

    public List<Employee> findAllEmployeesByDepartmentId(long departmentId) {
        String sql = "SELECT * FROM employee2 WHERE department_id_long =?";
        List<Map<String, Object>> rowList = jdbcTemplate.queryForList(sql, departmentId);
        List<Employee> employeesList = new ArrayList<>();
        for (Map<String, Object> row : rowList) {
            Employee employee = new Employee();
            Integer id = (Integer) row.get("id");
            employee.setId(Long.valueOf(id));
            employee.setFirstName((String) row.get("first_name"));
            employee.setLastName((String) row.get("last_name"));
            employee.setBirthDate((java.sql.Date) row.get("birth_date"));
            employee.setDepartment((Long) row.get("department_id_long"));
            employee.setLogin((String) row.get("login"));
            employee.setPass((String) row.get("pass"));
            employee.setPass2((String) row.get("pass2"));
            employeesList.add(employee);
        }

        return employeesList;
    }
}
