package com.springboot.project.curdproject.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.curdproject.entity.Employee;
import com.springboot.project.curdproject.dao.EmployeeDAO;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO theemployeeDAO) {
        employeeDAO = theemployeeDAO;
    }

    // inject employee dao
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
    

    // expose "/employee" and return a list of employees
    
}
