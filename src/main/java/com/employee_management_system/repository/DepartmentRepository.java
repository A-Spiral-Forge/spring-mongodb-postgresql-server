package com.employee_management_system.repository;

import com.employee_management_system.models.Department;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    
}
