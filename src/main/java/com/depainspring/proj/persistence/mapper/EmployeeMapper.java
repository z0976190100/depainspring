package com.depainspring.proj.persistence.mapper;

import com.depainspring.proj.persistence.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

public interface EmployeeMapper extends RowMapper<Employee> {
}
