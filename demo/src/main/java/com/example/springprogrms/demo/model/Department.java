package com.example.springprogrms.demo.model;

import org.springframework.data.domain.Sort;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int department_id;
    @Column(name="departmentName")
    private String departmentName;
    @Column(name ="city")
    private String city;

    public Department() {
        super();
    }

    public Department(String department_name, String city) {
        super();

        this.departmentName = department_name;
        this.city = city;
    }

    public Department(int department_id, String department_name, String city) {
        super();
        this.department_id = department_id;
        this.departmentName = department_name;
        this.city = city;
    }

    public Department(int i) {
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String department_name) {
        this.departmentName = department_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + department_id + ", departmentName=" + departmentName + ", city=" + city
                + "]";
    }
}