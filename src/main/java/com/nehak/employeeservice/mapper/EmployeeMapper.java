package com.nehak.employeeservice.mapper;

import com.nehak.employeeservice.dto.EmployeeDto;
import com.nehak.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);
    @Mapping(source = "departmentCode", target = "departmentCode")
    EmployeeDto mapToEmployeeDto(Employee employee);
    @Mapping(source = "departmentCode", target = "departmentCode")
    Employee mapToEmployee(EmployeeDto employeeDto);
}
