package com.example.employee_api.service;

import com.example.employee_api.dto.EmployeeDto;
import com.example.employee_api.entity.Department;
import com.example.employee_api.entity.Employee;
import com.example.employee_api.exception.DepartmentNotFoundException;
import com.example.employee_api.exception.DuplicateResourceException;
import com.example.employee_api.exception.EmployeeNotFoundException;
import com.example.employee_api.repository.DepartmentRepository;
import com.example.employee_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeerepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees(){
        List<Employee>employees = employeerepository.findAll();
        System.out.println("le nombre d'employés : "+ employees.size());
       return employees;

    }
    public Employee getEmployeeById(Long id){
      return employeerepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

public Employee createEmployee(EmployeeDto e){

    if(employeerepository.findByEmail(e.getEmail()) != null) {
        throw new DuplicateResourceException("Email already exists");}
    Department department = departmentRepository.findById(e.getDepartmentId()).orElseThrow(()->new DepartmentNotFoundException("department not found"));

    Employee employee = new Employee();
    employee.setName(e.getName());
    employee.setEmail(e.getEmail());
    employee.setSalary(e.getSalary());
    employee.setDepartment(department);
    return employeerepository.save(employee);
}
public Employee updateEmployee(Long id, EmployeeDto e){
    Employee existing = employeerepository.findByEmail(e.getEmail());
    if(existing != null && !existing.getId().equals(id)) {
        throw new DuplicateResourceException("Email already exists");
    }
    Department department = departmentRepository.findById(e.getDepartmentId()).orElseThrow(()->new DepartmentNotFoundException("department not found"));

    Employee employee =employeerepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employee.setName(e.getName());
        employee.setEmail(e.getEmail());
        employee.setSalary(e.getSalary());
        employee.setDepartment(department);
        return employeerepository.save(employee);
}

public void deleteEmployee(Long id){
      Employee employee = employeerepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(("employee not found")));
      employeerepository.delete(employee);
      System.out.println("l'employé dont id "+ id + "est supprimé ");
}
public Employee searchEmployeeByEmail(String email){
        Employee employee = employeerepository.findByEmail(email);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee not found with email: " + email);
        }
        return employee;
    }
}
