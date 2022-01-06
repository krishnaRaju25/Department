package com.example.springprogrms.demo.Repository;

import com.example.springprogrms.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {


   // List<Department> findAllCity();
}
