package com.example.employee_api.repository;

import com.example.employee_api.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByName(String name);
}
