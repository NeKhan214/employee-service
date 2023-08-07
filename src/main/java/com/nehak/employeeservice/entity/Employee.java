package com.nehak.employeeservice.entity;

import com.nehak.employeeservice.enums.DepartmentCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    @Column(nullable = false, unique = true)
    String email;
    @Enumerated(EnumType.STRING)
    DepartmentCode departmentCode;
}
