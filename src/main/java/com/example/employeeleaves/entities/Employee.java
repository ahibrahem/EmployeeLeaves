package com.example.employeeleaves.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="employee")
public class Employee implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="mobile")
    private String mobile;

    @Column(name="email")
    private String email;


    @OneToMany(mappedBy="empId")
    private List<Leaves> leavesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Leaves> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(List<Leaves> leavesList) {
        this.leavesList = leavesList;
    }
}
