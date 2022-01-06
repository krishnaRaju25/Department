package com.example.springprogrms.demo.Exception;

public class DepartmentIdCheckException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DepartmentIdCheckException() {
        super();
    }
    public DepartmentIdCheckException(String message){
        super(message);
    }
}
