package com.springboot.project.curdproject.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.curdproject.entity.Employee;
import com.springboot.project.curdproject.service.EmployeeService;
import com.springboot.project.curdproject.dao.EmployeeDAO;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

  

    public EmployeeRestController(EmployeeService theEmployeeService) {
       employeeService = theEmployeeService;
    }



    // inject employee dao
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    

    // expose "/employee" and return a list of employees
    
}
