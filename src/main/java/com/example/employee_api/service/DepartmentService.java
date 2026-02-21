package com.example.employee_api.service;

import com.example.employee_api.entity.Department;
import com.example.employee_api.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public  DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        List<Department> Departments = departmentRepository.findAll();
        System.out.println("le nombre des dapartements sont "+ Departments.size());
        return Departments;
    }

    public Department getDepartmentById(Long id){
        Department department = departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
        return department;
    }
}
