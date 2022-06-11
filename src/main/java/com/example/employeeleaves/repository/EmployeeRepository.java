package com.example.employeeleaves.repository;

import com.example.employeeleaves.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
