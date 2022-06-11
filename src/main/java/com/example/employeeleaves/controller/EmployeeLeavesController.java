package com.example.employeeleaves.controller;


import com.example.employeeleaves.entities.Employee;
import com.example.employeeleaves.entities.Leaves;
import com.example.employeeleaves.pojo.EmployeeLeaves;
import com.example.employeeleaves.service.EmployeeService;
import com.example.employeeleaves.service.LeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeLeavesController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LeavesService leavesService;

    @GetMapping("/employees")
    public ResponseEntity list() {
        try {
            List<Employee> result = employeeService.getAllEmployees();
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity add(@RequestBody Employee employee) {
        try {
            String result = employeeService.saveEmployee(employee);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleteEmployee")
    public ResponseEntity deleteEmployee(@RequestParam Long id) {
        try {
            String result = employeeService.deleteEmplopyee(id);
            return new ResponseEntity(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addLeaves")
    public ResponseEntity add(@RequestBody Leaves leaves) {
        try {
            String result = leavesService.saveLeaves(leaves);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/leaves")
    public ResponseEntity findLeaves() {
        try {
            List<EmployeeLeaves> result = leavesService.findLeaves();
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



