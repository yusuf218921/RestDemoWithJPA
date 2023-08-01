package com.example.demo.dataAccess;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    void delete(Integer id);
    void update(Employee employee);
    Employee find(Integer id);
    List<Employee> findAll();
}
