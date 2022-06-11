package com.example.employeeleaves.service;


import com.example.employeeleaves.entities.Employee;
import com.example.employeeleaves.entities.Leaves;
import com.example.employeeleaves.pojo.EmployeeLeaves;
import com.example.employeeleaves.repository.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LeavesService {

    @Autowired
    LeavesRepository leavesRepository;

    public String saveLeaves(Leaves leaves) {
        try {
            leavesRepository.save(leaves);
            return "leaves Saved";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<EmployeeLeaves> findLeaves() {
        List<EmployeeLeaves> empList = new ArrayList<>();
        try {
            List<Object[]> list = leavesRepository.findLeaves();
            for (Object[] ob : list){
                EmployeeLeaves employeeLeaves = new EmployeeLeaves();
                employeeLeaves.setEmp_id((Integer)ob[0]);
                employeeLeaves.setEmp_name((String)ob[1]);
                employeeLeaves.setLeave_count(((BigInteger)ob[2]).intValue());
                empList.add(employeeLeaves);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return empList;
    }
}
