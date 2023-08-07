package com.nehak.employeeservice.dto;

import com.nehak.employeeservice.enums.DepartmentCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Employee DTO model")
public class EmployeeDto {
    Long id;
    @Schema(name = "firstName", example = "Neha", type = "String", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Pattern(regexp = "[A-Za-z ]{1,25}")
    String firstName;
    @Schema(name = "lastName", example = "Khan", type = "String", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Pattern(regexp = "[A-Za-z ]{1,25}")
    String lastName;
    @Email
    @Schema(name = "email", example = "er.nehakhan@gmail.com", type = "String", requiredMode = Schema.RequiredMode.REQUIRED)
    String email;
    @NotNull
    @Schema(name = "departmentCode", requiredMode = Schema.RequiredMode.REQUIRED, example = "IT")
    private DepartmentCode departmentCode;
}
