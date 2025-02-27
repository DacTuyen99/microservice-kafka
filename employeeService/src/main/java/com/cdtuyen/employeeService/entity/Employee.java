package com.cdtuyen.employeeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;
}
