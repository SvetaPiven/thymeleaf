package com.example.springbootwebapp.service;

import com.example.springbootwebapp.model.dto.EmployeeDto;
import com.example.springbootwebapp.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    void deleteById(long id);

    EmployeeDto getById(long id);

    void save(EmployeeDto employeeDto);
}
