package com.example.employeeleaves.pojo;

import java.io.Serializable;

public class EmployeeLeaves implements Serializable {

    private Integer emp_id;
    private  String emp_name;
    private Integer leave_count;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Integer getLeave_count() {
        return leave_count;
    }

    public void setLeave_count(Integer leave_count) {
        this.leave_count = leave_count;
    }
}
