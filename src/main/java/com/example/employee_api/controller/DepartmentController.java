package com.example.employee_api.controller;

import com.example.employee_api.entity.Department;
import com.example.employee_api.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getAllDepartments(){
      return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getOneDepartment(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department d){
        return departmentService.createDepartment(d);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment (@PathVariable Long id){
         departmentService.deleteDepartment(id);

    }
}
