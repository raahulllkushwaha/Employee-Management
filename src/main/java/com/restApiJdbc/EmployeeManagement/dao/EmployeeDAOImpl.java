package com.restApiJdbc.EmployeeManagement.dao;

import com.restApiJdbc.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO tbl_employees (name, email, department) VALUES(?,?,?)", new Object[] {employee.getName(), employee.getEmail(), employee.getDepartment()});
    }

    @Override
    public int update(Employee employee, int id) {
        return jdbcTemplate.update("UPDATE tbl_employees SET name=?, email=?, department=? WHERE id=?", new Object[]{employee.getName(), employee.getEmail(), employee.getDepartment(), id});
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Employee> getAll() {
       return jdbcTemplate.query("SELECT * FROM tbl_employees", new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_employees WHERE  id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
    }
}
