package com.nehak.employeeservice.service;

import com.nehak.employeeservice.dto.DepartmentDto;
import com.nehak.employeeservice.enums.DepartmentCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8080/", value = "department-service") //value provide name for API Client
public interface APIClient {

    @GetMapping("api/departments/getDepartmentByCode")
    DepartmentDto getDepartmentByCode(@RequestParam("code") DepartmentCode departmentCode);
}
