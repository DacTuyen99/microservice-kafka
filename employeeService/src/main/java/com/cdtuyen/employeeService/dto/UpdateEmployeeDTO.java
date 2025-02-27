package com.cdtuyen.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;
}
