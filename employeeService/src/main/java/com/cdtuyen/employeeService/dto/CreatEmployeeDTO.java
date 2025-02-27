package com.cdtuyen.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatEmployeeDTO {
    private String firstName;
    private String LastName;
    private String Kin;
}
