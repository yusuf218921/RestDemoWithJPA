package com.example.demo.business;

import com.example.demo.dataAccess.EmployeeDao;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public Employee find(int id) {
        return employeeDao.find(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
