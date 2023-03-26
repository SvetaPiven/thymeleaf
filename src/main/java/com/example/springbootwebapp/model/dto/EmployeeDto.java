package com.example.springbootwebapp.model.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;

    private Integer age;
}
