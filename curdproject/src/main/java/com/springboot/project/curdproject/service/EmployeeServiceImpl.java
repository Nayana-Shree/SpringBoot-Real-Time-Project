package com.springboot.project.curdproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.curdproject.dao.EmployeeDAO;
import com.springboot.project.curdproject.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeDAO employeeDAO; 

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
    employeeDAO = theemployeeDAO;
}



    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return employeeDAO.findAll();
    }

    
    
}
