package com.cdtuyen.employeeService.service;

import com.cdtuyen.commonServer.exception.CommonErrorCode;
import com.cdtuyen.commonServer.exception.item.DataNotFoundException;
import com.cdtuyen.employeeService.dto.EmployeePageDTO;
import com.cdtuyen.employeeService.dto.UpdateEmployeeDTO;
import com.cdtuyen.employeeService.entity.Employee;
import com.cdtuyen.employeeService.repository.EmployeeRepository;
import com.cdtuyen.employeeService.service.specification.EmployeeSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeSpecification employeeSpecification;
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Transactional
    public Employee updateEmployee(UpdateEmployeeDTO updateEmployeeDTO, Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound, "", "EmployeeService");
        }
        Employee employee = Employee.builder().id(updateEmployeeDTO.getId()).firstName(updateEmployeeDTO.getFirstName())
                .lastName(updateEmployeeDTO.getLastName()).isDisciplined(updateEmployeeDTO.getIsDisciplined()).kin(updateEmployeeDTO.getKin()).build();
        return employeeRepository.save(employee);
    }

    public EmployeePageDTO getAllEmployee(int page, int size, String firstName){
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Employee> employeePage = employeeRepository.findAll(
            Specification.where(employeeSpecification.containFirstName(firstName)),
                pageRequest
        );
        return EmployeePageDTO.builder().currentPage(page+1).totalPage(employeePage.getTotalPages())
                .list(employeePage.toList()).total(employeePage.getTotalElements()).build();
    }
}
