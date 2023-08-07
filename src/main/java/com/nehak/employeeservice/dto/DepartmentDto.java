package com.nehak.employeeservice.dto;

import com.nehak.employeeservice.enums.DepartmentCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long id;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z ]{1,25}")
    @Schema(name = "departmentName",  type = "String", requiredMode = Schema.RequiredMode.REQUIRED, example = "INFORMATION TECHNOLOGY")
    private String departmentName;
    @Pattern(regexp = "[a-zA-Z ]{1,50}")
    @Schema(name = "departmentDescription", type = "String", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Information Technology Department")
    private String departmentDescription;
    @NotNull
    @Schema(name = "departmentCode", requiredMode = Schema.RequiredMode.REQUIRED, example = "IT")
    private DepartmentCode departmentCode;
}
