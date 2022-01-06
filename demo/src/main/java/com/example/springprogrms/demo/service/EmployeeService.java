package com.example.springprogrms.demo.service;

import com.example.springprogrms.demo.Exception.DepartmentIdCheckException;
import com.example.springprogrms.demo.Exception.DepartmentNotFoundException;
import com.example.springprogrms.demo.Exception.EmployeeAlreadyExistsException;
import com.example.springprogrms.demo.Repository.DepartmentRepository;
import com.example.springprogrms.demo.Repository.EmployeeRepository;
import com.example.springprogrms.demo.model.Department;
import com.example.springprogrms.demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class EmployeeService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        System.out.println("getAllEmployees");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int eid) {
        System.out.println("getEmployeeById");
        return employeeRepository.findById(eid).get();
    }



//    public Employee updateEmployee(Employee emp) {
//        System.out.println("updateEmployee");
////		empList.add(emp); // dummy code
//
//            System.out.print(emp.getFirstName().toUpperCase());
//            return null;
//    }

    public Employee deleteEmployee(int eid) {

        System.out.println("deleteEmployee " + eid);
      employeeRepository.deleteById(eid);
   return null;
    }

    public List<Employee> getFirstname(String fname)
    {
        System.out.println("first name" +fname);
      return employeeRepository.findByFirstName(fname);

    }
    public List<Employee> getGreaterSalary(double salary)
    {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
    public List<Employee> getByCity(String city)
    {
        System.out.println("first name" +city);
        return employeeRepository.findByDepartment_City(city);

    }

//    public Employee addEmployee(Employee emp) {
//        LOG.info("addEmployee");
//        if (emp.getDepartment() != null) {
//            if (departmentRepository.existsById(emp.getDepartment().getDepartment_id())) {
//                LOG.info("employee added successfully.");
//                return employeeRepository.save(emp); // INSERT INTO ...
//            }
//        }
//        LOG.warn("employee was not added because given department if does not exist.");
//        return null;
//    }

    public Employee addEmployee(Employee emp) {
        LOG.info("addEmployee");
        if (!employeeRepository.existsById(emp.getEmployeeId())) {
            if (emp.getDepartment() == null) {   // d.id = null eid= 101 ename=varun esalary = 13000
                return employeeRepository.save(emp);   // save in repo
            } else if (departmentRepository.existsById(emp.getDepartment().getDepartment_id())) { // d.id =10 emp values
                return employeeRepository.save(emp); // save in repo where d.id=10 has city= TN dep = 20(in department repo)
            } else {
                throw new DepartmentNotFoundException(); // d=23  no department_id has there in 23
            }
        } else {
            throw new EmployeeAlreadyExistsException(); // employee exist no duplicate
        }
    }
// public Department addDep(Department dep)
// {
//     if(departmentRepository.existsById(dep.getDepartment_id()))
//     {
//         departmentRepository.save(dep);
//     }else if(dep.getDepartment_id() > 0 )
//      {
//         departmentRepository.save(dep);
//     } else {
//         throw new DepartmentIdCheckException();
//     }
//     return dep;
// }
// public List<Department> getAlldep()
// {
//   return departmentRepository.findAll();
// }


}
