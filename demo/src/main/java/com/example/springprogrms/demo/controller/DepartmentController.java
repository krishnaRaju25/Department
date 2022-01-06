package com.example.springprogrms.demo.controller;

import com.example.springprogrms.demo.model.Department;
import com.example.springprogrms.demo.model.Employee;
import com.example.springprogrms.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/dep")
public class DepartmentController implements IDepartmentController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/adddep")
    public ResponseEntity<Department> addDep(@RequestBody Department dep)
    {
        LOG.info("adddep " + dep.toString());
        Department department = departmentService.addDep(dep);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Department added successfully."); // more can be added
        HttpStatus status = HttpStatus.CREATED; //201 response
        return new ResponseEntity<Department>(department, headers, status);
    }

    @GetMapping("/deplist")
    public List<Department> depList()
    {
        return departmentService.getAlldep();
    }

//    @GetMapping("/did/{did}")
//    public ResponseEntity<Department> getDepById(@PathVariable(name = "did") int did) {
//        LOG.info("getEmpById " + did);
//        return new ResponseEntity<Department>(departmentService.getByid(did), HttpStatus.OK);
//    }
//    @RequestMapping(value = "dept/{did}", method = RequestMethod.GET, produces = "application/json"
//            /* , consumes = "application/json" */)
//    public ResponseEntity<Department> getDepById(@PathVariable(name = "did") int did) {
//        LOG.info("getEmpById " + did);
////		return new ResponseEntity<Employee>(departmentService.getDepartmentById(eid), HttpStatus.OK);
//        return new ResponseEntity<Department>(departmentService.getByid(did), HttpStatus.OK);
//    }

    @GetMapping("/countOfMembers")
    public int countOfMembers() {
      //  return departmentService.getCount();
        return departmentService.getCount().intValue();
    }


    @RequestMapping(value = "dept/{did}", method = RequestMethod.GET, produces = "application/json"
            /* , consumes = "application/json" */)
    public ResponseEntity<Department> getDepById(@PathVariable(name = "did") int did) {
        LOG.info("getEmpById " + did);
//		return new ResponseEntity<Employee>(departmentService.getDepartmentById(eid), HttpStatus.OK);
        //return null;
       return new ResponseEntity<Department>(departmentService.getByid(did), HttpStatus.OK);

    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAlldep() {
        return new ResponseEntity<List<Department>>(departmentService.getAlldep(), HttpStatus.OK);
    }


    }



