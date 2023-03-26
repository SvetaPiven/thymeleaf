package com.example.springbootwebapp.service;

import com.example.springbootwebapp.model.dto.EmployeeDto;
import com.example.springbootwebapp.model.entity.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream().map(
                        employee -> EmployeeDto
                                .builder()
                                .id(employee.getId())
                                .name(employee.getName())
                                .email(employee.getEmail())
                                .build()
                ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getById(long id) {
        var emp = employeeRepository.findById(id)
                .orElseThrow();
        return EmployeeDto.builder()
                .id(emp.getId())
                .name(emp.getName())
                .email(emp.getEmail())
                .build();
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        employeeRepository.save(Employee.builder()
                        .id(employeeDto.getId())
                        .email(employeeDto.getEmail())
                        .age(employeeDto.getAge())
                        .name(employeeDto.getName())
                .build());
    }
}
