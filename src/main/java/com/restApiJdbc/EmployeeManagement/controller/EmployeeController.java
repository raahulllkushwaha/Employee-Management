package com.restApiJdbc.EmployeeManagement.controller;


import com.restApiJdbc.EmployeeManagement.EmployeeManagementApplication;
import com.restApiJdbc.EmployeeManagement.dao.EmployeeDAO;
import com.restApiJdbc.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        return eDAO.save(employee)+ " Number of rows saved to the database";
    }
}
