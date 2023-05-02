package com.springboot.project.curdproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.curdproject.dao.EmployeeRepository;
import com.springboot.project.curdproject.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeRepository employeeRepository; //changing DAO to employeeRepository

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
    employeeRepository = theEmployeeRepository;
}



    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }



    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        
        return employeeRepository.save(theEmployee);
    }

  
    @Override
    public void deleteById(int theId) {
        
        employeeRepository.deleteById(theId);
    }

    
    
}
