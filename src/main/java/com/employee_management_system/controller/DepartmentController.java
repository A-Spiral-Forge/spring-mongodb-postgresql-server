package com.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management_system.models.Department;
import com.employee_management_system.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> getAllDepartments() {
        try {
            List<Department> departments = departmentRepository.findAll();
            if (departments == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(departments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id) {
        try {
            Department department = departmentRepository.findOne(id);
            if (department == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(department, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        try {
            Department dep = departmentRepository.save(
                new Department(
                    department.getDepartmentId(),
                    department.getDepartmentName()
                )
            );
            return new ResponseEntity<>(dep, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department department) {
        try {
            Department dep = departmentRepository.findOne(id);
            if (dep == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            dep.setDepartmentName(department.getDepartmentName());
            return new ResponseEntity<>(departmentRepository.save(dep), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable String id) {
        try {
            Department dep = departmentRepository.findOne(id);
            if (dep == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            departmentRepository.delete(dep);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
