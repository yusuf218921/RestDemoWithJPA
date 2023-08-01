package com.example.demo.dataAccess;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee employee = this.find(id);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee find(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }
}
