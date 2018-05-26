package com.depainspring.proj.persistence.mapper;

import com.depainspring.proj.persistence.entity.Department;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {


    public Department mapRow(ResultSet resultSet, int id) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setTitle(resultSet.getString("title"));
        return department;
    }


}
