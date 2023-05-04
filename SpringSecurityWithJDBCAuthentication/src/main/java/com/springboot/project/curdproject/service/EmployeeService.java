package com.springboot.project.curdproject.service;

import java.util.List;
import com.springboot.project.curdproject.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
    
}
