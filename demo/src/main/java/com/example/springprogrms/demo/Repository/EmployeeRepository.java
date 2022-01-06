package com.example.springprogrms.demo.Repository;


import com.example.springprogrms.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  List<Employee>  findByFirstName(String fname);

//  @Query(value = "select * from employee where salary = ?1")
  List<Employee> findBySalaryGreaterThan(double salary);
 List<Employee> findByDepartment_City(String city);
}