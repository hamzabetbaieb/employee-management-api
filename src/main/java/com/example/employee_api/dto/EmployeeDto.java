package com.example.employee_api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDto {

    private String name;
    @Column(unique = true)
    private String email;
    private Double salary;

    /*public Employee(){};

    public Employee(Long id, String name, String email, Double salary) {
        Id = id;
        Name = name;
        Email = email;
        Salary = salary;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
