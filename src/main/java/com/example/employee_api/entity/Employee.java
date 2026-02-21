package com.example.employee_api.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")// le nom de la column du FK
    private Department department;

    public Employee(){};

    public Employee(Long id, String name, String email, Double salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Department getDepartment() {return department;}

    public void setDepartment(Department department) {this.department = department;}
}
