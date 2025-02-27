package com.cdtuyen.employeeService.dto;

import com.cdtuyen.employeeService.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePageDTO {
    private Long total = 0L;
    private Integer currentPage;
    private Integer totalPage;
    private List<Employee> list = new ArrayList<>();
}
