package com.nehak.employeeservice.service;

import com.nehak.employeeservice.dto.APIResponseDto;
import com.nehak.employeeservice.dto.EmployeeDto;
import com.nehak.employeeservice.exception.ResourceNotFoundException;

public interface EmployeeService {

    public EmployeeDto addEmployee(EmployeeDto employeeDto);
    public APIResponseDto getEmployeeById(Long employeeId) throws ResourceNotFoundException;
}
