package net.javaguides.employeeservice.Service;

import net.javaguides.employeeservice.Dto.APIResponseDto;
import net.javaguides.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {
    //create save employee
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //get employee
//    EmployeeDto getEmployeeById(Long employeeId);
    APIResponseDto getEmployeeById(Long employeeId);


}
