package com.javaguides.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmloyeeByid(@PathVariable("id") Long employeeId){
        return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employeeId,employeeDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId ){
        employeeService.deleteEmployee(employeeId);
    }
}
