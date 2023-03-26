package com.example.springbootwebapp.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
