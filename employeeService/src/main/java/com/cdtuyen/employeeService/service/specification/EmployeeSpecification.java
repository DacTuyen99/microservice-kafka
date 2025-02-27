package com.cdtuyen.employeeService.service.specification;

import com.cdtuyen.employeeService.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeSpecification {
    public Specification<Employee> containFirstName(final String firstName) {
        return (root, query, criteriaBuilder) -> {
            if (firstName == null || firstName.trim().isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase()  + "%");
        };
    }
}
