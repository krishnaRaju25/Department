package com.example.springprogrms.demo.controller;

import com.example.springprogrms.demo.Repository.DepartmentRepository;
import com.example.springprogrms.demo.model.Department;
import com.example.springprogrms.demo.model.Employee;
import com.example.springprogrms.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin (origins = "*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//    @GetMapping("/emp/{eid}")
//    public Employee emp(@PathVariable(name = "eid")int eid) {
//        LOG.info("emp");
//        return employeeService.getEmployeeById(eid);
//    }

    @GetMapping("/getempbyid/{eid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
        LOG.info("getEmpById " + eid);
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
    }

    @GetMapping("/emplist")
    public List<Employee> empList() {
        LOG.info("empList");
        return employeeService.getAllEmployees();
    }

//    @PostMapping("/addemp") //no responese
//    public Employee addEmp(@RequestBody Employee emp) {
//       LOG.info("addEmp");
//        return employeeService.addEmployee(emp);
//    }

    @PostMapping("/addemp") //trying to communicate with http response
    public ResponseEntity<Employee> addEmp(@RequestBody Employee emp) {
        LOG.info("addEmp " + emp.toString());
        Employee empTemp = employeeService.addEmployee(emp);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Employee added successfully."); // more can be added
        HttpStatus status = HttpStatus.CREATED; //201 response
        return new ResponseEntity<Employee>(empTemp, headers, status);
    }
    @GetMapping("/fname/{fname}")
    public List<Employee> fname(@PathVariable(name = "fname") String fname)
    {
        LOG.info("first name ");
        return employeeService.getFirstname(fname);
    }

    @GetMapping("/cname/{city}")
    public List<Employee> city(@PathVariable(name = "city") String city)
    {
        LOG.info("city" +city);
        return employeeService.getByCity(city);
    }

//    @PutMapping("/updateemp")
//    public Employee updateEmp(@RequestBody Employee emp) {
//        System.out.println("updateEmp");
//        return employeeService.updateEmployee(emp);
//    }
    //@GetMapping("/salary/{salary}")

    @DeleteMapping("/deleteemp/{eid}")
    public Employee deleteEmp(@PathVariable(name = "eid") int eid) {
        System.out.println("deleteEmp " + eid);
        return employeeService.deleteEmployee(eid);
    }
    @RequestMapping("/find/{eid}")
    public Employee find(@PathVariable(name = "eid") int eid)
    {
        return employeeService.getEmployeeById(eid);
    }

//     @PostMapping("/adddep")
//     public ResponseEntity<Department> addDep(@RequestBody Department dep)
//     {
//         LOG.info("adddep " + dep.toString());
//         Department department = employeeService.addDep(dep);
//         HttpHeaders headers = new HttpHeaders();
//         headers.add("message", "Department added successfully."); // more can be added
//         HttpStatus status = HttpStatus.CREATED; //201 response
//         return new ResponseEntity<Department>(department, headers, status);
//     }
//
//     @GetMapping("/deplist")
//    public List<Department> depList()
//     {
//         return employeeService.getAlldep();
//     }
//

}
