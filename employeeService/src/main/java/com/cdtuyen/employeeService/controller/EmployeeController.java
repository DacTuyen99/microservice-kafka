package com.cdtuyen.employeeService.controller;

import com.cdtuyen.employeeService.dto.CreatEmployeeDTO;
import com.cdtuyen.employeeService.dto.EmployeePageDTO;
import com.cdtuyen.employeeService.dto.UpdateEmployeeDTO;
import com.cdtuyen.employeeService.entity.Employee;
import com.cdtuyen.employeeService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody CreatEmployeeDTO creatEmployeeDTO){
        Employee employee = Employee.builder().firstName(creatEmployeeDTO.getFirstName()).lastName(creatEmployeeDTO.getLastName())
                .kin(creatEmployeeDTO.getKin()).isDisciplined(false).build();
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody UpdateEmployeeDTO updateEmployeeDTO, @PathVariable  Long id){
        return new ResponseEntity<>(employeeService.updateEmployee(updateEmployeeDTO, id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<EmployeePageDTO> getAllEmployee(@RequestParam(required = false) String firstName,
                                                          @RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(employeeService.getAllEmployee(page, size, firstName), HttpStatus.OK);
    }
}
