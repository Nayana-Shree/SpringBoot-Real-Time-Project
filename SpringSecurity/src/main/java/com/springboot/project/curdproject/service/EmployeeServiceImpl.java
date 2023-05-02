package com.springboot.project.curdproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.curdproject.dao.EmployeeDAO;
import com.springboot.project.curdproject.entity.Employee;

import jakarta.transaction.Transactional;

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



    @Override
    public Employee findById(int theId) {
        
        return employeeDAO.findById(theId);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        
        return employeeDAO.save(theEmployee);
    }


    @Transactional
    @Override
    public void deleteById(int theId) {
        
        employeeDAO.deleteById(theId);
    }

    
    
}
