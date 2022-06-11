package com.example.employeeleaves.repository;

import com.example.employeeleaves.entities.Leaves;
import com.example.employeeleaves.pojo.EmployeeLeaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeavesRepository extends JpaRepository<Leaves, Long> {


    @Query(value = "select e.id as emp_id,e.name  as emp_name, count(*) as leave_count \n" +
            "    from employee_schema.leaves l\n" +
            "    join employee_schema.employee e on e.id = l.employee_id\n" +
            "    group by e.id", nativeQuery = true)
    List<Object[]> findLeaves();
}