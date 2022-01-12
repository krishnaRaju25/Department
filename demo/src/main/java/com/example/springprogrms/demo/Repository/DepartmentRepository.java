package com.example.springprogrms.demo.Repository;

import com.example.springprogrms.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
   // @Query(value = "select city from department")
    List<Department> findByCity(String city);

    //  List<Department> findAllcity();


    // List<Department> findAllCity();
}
