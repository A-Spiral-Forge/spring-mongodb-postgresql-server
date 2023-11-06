package com.employee_management_system.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "department_id", nullable = false, length = 50)
    private String departmentId;

    @Column(name = "created_at", nullable = false, length = 50)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, length = 50)
    private Timestamp updatedAt;

    public Employee() {
    }

    public Employee(String name, String email, String departmentId) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String newDepartmentId){
        this.departmentId = newDepartmentId;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + ", departmentId='" + this.departmentId + '\'' + ", createdAt='" + this.createdAt + '\'' + ", updatedAt='" + this.updatedAt + '\'' + '}';
    }
}
