package com.example.springbootwebapp.repository;

import com.example.springbootwebapp.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeInMemoryRepositoryImpl implements EmployeeRepository {

    private final List<Employee> inMemoryStorage = new ArrayList<>(
            Arrays.asList(
                    Employee.builder()
                            .id(1L)
                            .name("John")
                            .email("john@gmail.com")
                            .age(25)
                            .build(),
                    Employee.builder()
                            .id(2L)
                            .name("Marry")
                            .email("marry@gmail.com")
                            .age(22)
                            .build()
            )
    );

    @Override
    public List<Employee> findAll() {
        return inMemoryStorage;
    }

    @Override
    public boolean deleteById(long id) {
        return inMemoryStorage.removeIf(
                item -> item.getId() == id
        );
    }

    @Override
    public Optional<Employee> findById(long id) {
        return inMemoryStorage.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() != null) {
            var emp = inMemoryStorage.stream()
                    .filter(item -> item.getId().equals(employee.getId()))
                    .findFirst().orElseThrow();
            emp.setEmail(employee.getEmail());
            emp.setName(employee.getName());
        } else {
            var emp = inMemoryStorage.stream()
                    .max(Comparator.comparingLong(Employee::getId)).orElseGet(() -> Employee
                            .builder()
                            .id(0L)
                            .build()).getId();
            inMemoryStorage.add(Employee
                    .builder()
                    .id(emp + 1)
                    .name(employee.getName())
                    .age(employee.getAge())
                    .email(employee.getEmail())
                    .build());
        }
    }
}
