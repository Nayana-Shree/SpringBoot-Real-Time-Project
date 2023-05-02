package com.springboot.project.curdproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.curdproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{ //this holds Employee-entity Integer-primarykey

    //by extending JPARepository we get be able to use all curd operations no need to implement any code manually
    
    
}
