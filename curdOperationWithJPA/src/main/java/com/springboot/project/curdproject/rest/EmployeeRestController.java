package com.springboot.project.curdproject.rest;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.curdproject.entity.Employee;
import com.springboot.project.curdproject.service.EmployeeService;

import java.util.List;

import javax.management.RuntimeErrorException;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

  

    // inject employee dao
    public EmployeeRestController(EmployeeService theEmployeeService) {
       employeeService = theEmployeeService;
    }


    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    
    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if( theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);

        }

        return theEmployee;
    }
     // add mapping for adding a new employee with post mapping
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        
        //setting the index 0 so that new employee inserted can be added to index 0
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    //add mapping for updating the existing employee with put mapping
    
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
  
    }

    // add mapping for deleting existing employee with delete mapping

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee not found with the given id -" +employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Delete employee id - " +employeeId;

    }
}

    


    
    

