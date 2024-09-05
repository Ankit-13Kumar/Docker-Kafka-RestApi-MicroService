package net.javaguides.employeeservice.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto Model Information "
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    @Schema(
            description = "firstName"
    )
    private String firstName;
    @Schema(
            description = "lastName"
    )
    private String lastName;
    @Schema(
            description = "email"
    )
    private String email;
    @Schema(
            description = "departmentCode"
    )
//    added
    private String departmentCode;
    //Added for new microservice
    @Schema(
            description = "organizationCode"
    )
    private String organizationCode;
}
