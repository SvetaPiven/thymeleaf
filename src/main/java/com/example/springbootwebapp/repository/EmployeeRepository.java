package com.example.springbootwebapp.repository;

import com.example.springbootwebapp.model.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();

    boolean deleteById(long id);

    Optional<Employee> findById(long id);

    void save(Employee employee);
}
