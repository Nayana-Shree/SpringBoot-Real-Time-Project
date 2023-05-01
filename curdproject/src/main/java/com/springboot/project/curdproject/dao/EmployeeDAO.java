package com.springboot.project.curdproject.dao;

import java.util.List;
import com.springboot.project.curdproject.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    
}
