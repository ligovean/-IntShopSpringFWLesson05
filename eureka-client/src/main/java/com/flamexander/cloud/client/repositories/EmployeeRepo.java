package com.flamexander.cloud.client.repositories;

import com.flamexander.cloud.client.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
}
