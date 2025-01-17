package net.javaguides.employeeservice.Mapper;

import net.javaguides.employeeservice.Dto.EmployeeDto;
import net.javaguides.employeeservice.Model.Employee;

public class EmployeeMapper {
    public  static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        return employee;
    }
}
