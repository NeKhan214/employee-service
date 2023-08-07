package com.nehak.employeeservice.controller;

import com.nehak.employeeservice.dto.APIResponseDto;
import com.nehak.employeeservice.dto.EmployeeDto;
import com.nehak.employeeservice.exception.ResourceNotFoundException;
import com.nehak.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
@Tag(
        name = "Employee Create and Get APIs",
        description = "APIs to save and get employee Details"
)
public class EmployeeController {

    EmployeeService employeeService;
    @PostMapping
    @Operation(summary = "Create Employee")
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Get Employee By Id")
    @GetMapping("getEmployee/")
    public ResponseEntity<APIResponseDto> getEmployeeById(@Valid @RequestParam(name = "employeeId", required = true) Long employeeId) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }
}
