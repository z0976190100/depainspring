package com.depainspring.proj.persistence.dao;

import com.depainspring.proj.persistence.entity.Department;
import com.depainspring.proj.persistence.mapper.DepartmentMapper;
import com.depainspring.proj.persistence.mapper.DepartmentMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private DepartmentMapper departmentMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDAOImpl(JdbcTemplate template, DepartmentMapperImpl mapper) {
        this.jdbcTemplate = template;
        this.departmentMapper = mapper;
    }

    public void saveDepartment(Department department) {
        String sql = "INSERT INTO department2 (title) VALUES (?)";
        jdbcTemplate.update(sql, department.getTitle());
    }

    public void updateDepartment(Department department) {
        String sql = "UPDATE department2 SET title=? WHERE id=?";
        jdbcTemplate.update(sql, department.getTitle(), department.getId());
    }

    public void removeDepartment(long id) {
        String sql = "DELETE FROM department2 WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Department getDepartmentById(long id) {
        String sql = "SELECT * FROM department2 WHERE id=?";
        return jdbcTemplate.queryForObject(sql, departmentMapper, id);
    }

    public List<Department> findAllDepartments() {
        String sql = "SELECT * FROM department2";
        return jdbcTemplate.query(sql, departmentMapper);
    }

    public int getEmployeeNumberByDepartment(Department department) {
        String sql = "SELECT id FROM employee2 WHERE department_id_long=?";
        List<Map<String, Object>> ids = jdbcTemplate.queryForList(sql, department.getId());
        return ids.size();
    }

}

