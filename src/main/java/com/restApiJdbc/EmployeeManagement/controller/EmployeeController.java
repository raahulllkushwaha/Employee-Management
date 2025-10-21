package com.restApiJdbc.EmployeeManagement.controller;


import com.restApiJdbc.EmployeeManagement.dao.EmployeeDAO;
import com.restApiJdbc.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO eDAO;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return eDAO.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return eDAO.getById(id);
    }
}
