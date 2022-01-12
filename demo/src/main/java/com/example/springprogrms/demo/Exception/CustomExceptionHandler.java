package com.example.springprogrms.demo.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Object> handleDepartmentNotFoundException() {
        LOG.error("handleDepartmentNotFoundException");
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This department does not exist.");
        return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException() {
        LOG.error("handleEmployeeNotFoundException");
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This employee does not exist.");
        return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmployeeAlreadyException() {
        LOG.error("handleEmployeeAlreadyException");
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This employee already exists.");
        return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartmentIdCheckException.class)
    public ResponseEntity<Object> departmentIdCheckException(){
        LOG.error("id should be above zero");
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Id should not be less than zero.");
        return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
    }

}
