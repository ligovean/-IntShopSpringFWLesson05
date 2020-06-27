package com.flamexander.cloud.client.services;

import com.flamexander.cloud.client.entities.Employee;
import com.flamexander.cloud.client.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployee(){
        System.out.println("=========================================BEFORE Req!");
        List<Employee> empls = (List<Employee>) employeeRepo.findAll();
        System.out.println("=========================================AFTER Req!");
//        return "hello EurekaClient";
        return empls;
    }

}
