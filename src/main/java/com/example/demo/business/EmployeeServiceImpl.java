package com.example.demo.business;

import com.example.demo.dataAccess.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }


    @Override
    public Employee find(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
