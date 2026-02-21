package com.example.employee_api.controller;

import com.example.employee_api.dto.EmployeeDto;
import com.example.employee_api.entity.Employee;
import com.example.employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    private final EmployeeService employeeservice;
    public EmployeeController (EmployeeService employeeservice){
        this.employeeservice=employeeservice;

    }

    @GetMapping
    public List<Employee> getAllEmployees(){
       return employeeservice.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeservice.getEmployeeById(id);
    }
@PostMapping(path="/add")
    public Employee createEmployee (@RequestBody EmployeeDto e){
        return employeeservice.createEmployee(e);
}
@PutMapping(path="/update/{id}")
        public Employee updateEmployee (@PathVariable Long id, @RequestBody EmployeeDto e){
          return employeeservice.updateEmployee(id, e) ;

    }
    @DeleteMapping(path ="/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeservice.deleteEmployee(id);
    }
    @GetMapping(path="/search")
public Employee searchEmployeeByEmail(@RequestParam String email){
        return employeeservice.searchEmployeeByEmail(email);
}
}
