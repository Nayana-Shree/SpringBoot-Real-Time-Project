package com.springboot.project.curdproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.project.curdproject.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for emtity manager
    private EntityManager entityManager;

    //define constructor for constructor injection
    
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theentityManager) {
        this.entityManager = theentityManager;
    }
    
    
    @Override
    public List<Employee> findAll() {
        
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class); 

        // excute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // eturn the results
        return employees;
    }

    
    
}
