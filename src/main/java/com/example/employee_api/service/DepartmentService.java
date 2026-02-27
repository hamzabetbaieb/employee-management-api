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
    public Department createDepartment (Department department ){
      if (departmentRepository.findByName(department.getName())!=null){
          throw new RuntimeException("department already exists");
      }
        if (department.getName() == null || department.getName().isBlank()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
      Department d = new Department();
      d.setName(department.getName());
      return departmentRepository.save(d);

    }
    public void deleteDepartment (Long id){
        Department department = departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("department not found"));
        departmentRepository.delete(department);
        System.out.println("department deleted successfully");
    }
}
