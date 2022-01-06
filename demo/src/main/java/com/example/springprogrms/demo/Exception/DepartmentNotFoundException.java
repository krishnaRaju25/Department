package com.example.springprogrms.demo.Exception;
    public class DepartmentNotFoundException extends RuntimeException { // creates unchecked exception

        private static final long serialVersionUID = 1L;

        public DepartmentNotFoundException() {
            super();
        }

        public DepartmentNotFoundException(String message) { // message = This department is not found.
            super(message);
        }
}
