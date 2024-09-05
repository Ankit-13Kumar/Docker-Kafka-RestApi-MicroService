package net.javaguides.employeeservice.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.Dto.EmployeeDto;
import net.javaguides.employeeservice.Model.Employee;
import net.javaguides.employeeservice.Repository.EmployeeRepository;
import net.javaguides.employeeservice.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {
    //Autowired no need
    private EmployeeRepository employeeRepository;

    //create employee
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert jpa to dto
        Employee employee=new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail()
                );
        //save
        Employee savedEmployee=employeeRepository.save(employee);
        //convert dto to jpa
        EmployeeDto savedEmployeeDto=new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
        return savedEmployeeDto;
    }

    //create get method
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();
        //convert
        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        return employeeDto;
    }
}
