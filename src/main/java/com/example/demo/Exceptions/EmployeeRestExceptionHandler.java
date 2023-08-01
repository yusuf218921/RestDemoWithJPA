package com.example.demo.Exceptions;

import com.example.demo.Response.EmployeeErrorResponse;
import com.example.demo.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFound(EmployeeNotFoundException exc) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<EmployeeErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeError(RuntimeException exc) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<EmployeeErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
