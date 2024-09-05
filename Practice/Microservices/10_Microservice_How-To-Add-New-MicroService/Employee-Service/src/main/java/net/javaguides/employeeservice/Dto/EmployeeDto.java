package net.javaguides.employeeservice.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
//    added
    private String departmentCode;
    //Added for new microservice
    private String organizationCode;
}
