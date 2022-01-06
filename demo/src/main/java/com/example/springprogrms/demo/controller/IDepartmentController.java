package com.example.springprogrms.demo.controller;

import java.util.List;

import com.example.springprogrms.demo.model.Department;
import com.example.springprogrms.demo.model.Employee;
import org.springframework.http.ResponseEntity;



public interface IDepartmentController {

    public abstract int countOfMembers();

    public abstract ResponseEntity<Department> getDepById(int did);

    public abstract ResponseEntity<List<Department>> getAlldep();


}