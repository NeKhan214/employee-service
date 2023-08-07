package com.nehak.employeeservice.service.impl;

import com.nehak.employeeservice.dto.APIResponseDto;
import com.nehak.employeeservice.dto.DepartmentDto;
import com.nehak.employeeservice.dto.EmployeeDto;
import com.nehak.employeeservice.entity.Employee;
import com.nehak.employeeservice.exception.ResourceNotFoundException;
import com.nehak.employeeservice.mapper.EmployeeMapper;
import com.nehak.employeeservice.repository.EmployeeRepository;
import com.nehak.employeeservice.service.APIClient;
import com.nehak.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private WebClient webClient;

//    RestTemplate restTemplate;
    private APIClient apiClient;

    private static final String GET_DEPARTMENT_URL = "http://localhost:8080/api/departments/getDepartmentByCode?code=%s";

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployee(employeeDto);
        return EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "EmployeeId", String.valueOf(employeeId))
        );
//        ResponseEntity<DepartmentDto> dtoResponseEntity = restTemplate.getForEntity(String.format(GET_DEPARTMENT_URL,employee.getDepartmentCode().toString()),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = webClient.get()
//                .uri(String.format(GET_DEPARTMENT_URL,employee.getDepartmentCode().toString()))
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block(); // make synchronous call
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        return new APIResponseDto(EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(employee), departmentDto);
    }
}
