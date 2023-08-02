package com.example.demo.rest;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.business.EmployeeService;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        if (id >= employeeService.findAll().size()) {
            throw new EmployeeNotFoundException("Employee not found - " + id);
        }

        return employeeService.find(id);

    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public void add(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employees")
    public void delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }
}
