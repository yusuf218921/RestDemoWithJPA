package com.example.demo.business;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(Employee employee);
    Employee find(int id);
    List<Employee> findAll();
}
