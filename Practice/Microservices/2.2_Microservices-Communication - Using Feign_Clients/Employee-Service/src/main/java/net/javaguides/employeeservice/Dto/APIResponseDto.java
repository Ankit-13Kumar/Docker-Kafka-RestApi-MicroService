package net.javaguides.employeeservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//send these two objects to the clients
//impl class has logic
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}
