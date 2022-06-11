package com.example.employeeleaves.service;


import com.example.employeeleaves.entities.Employee;
import com.example.employeeleaves.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public String saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "employee Saved";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String deleteEmplopyee(long id) {
        try {
             employeeRepository.deleteById(id);
            return "employee Deleted";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}

