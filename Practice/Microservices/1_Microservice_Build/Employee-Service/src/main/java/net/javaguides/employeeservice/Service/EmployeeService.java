package net.javaguides.employeeservice.Service;

import net.javaguides.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {
    //create save employee
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //get employee
    EmployeeDto getEmployeeById(Long employeeId);

}
