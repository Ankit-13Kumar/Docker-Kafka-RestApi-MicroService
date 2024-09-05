package net.javaguides.employeeservice.Service.Impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.Dto.APIResponseDto;
import net.javaguides.employeeservice.Dto.DepartmentDto;
import net.javaguides.employeeservice.Dto.EmployeeDto;
import net.javaguides.employeeservice.Model.Employee;
import net.javaguides.employeeservice.Repository.EmployeeRepository;
import net.javaguides.employeeservice.Service.APIClient;
import net.javaguides.employeeservice.Service.EmployeeService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
//circuit annotation
@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
public class EmployeeServiceImpl implements EmployeeService {
    //Autowired no need
    private EmployeeRepository employeeRepository;
//    Added for microservices
    //private RestTemplate restTemplate;
   // uncomment for circuit braker
     private WebClient webClient;

    //feign client
    //comment fro circuit breaker
    //private APIClient apiClient;

    //create employee
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert jpa to dto
        Employee employee=new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail(),
//                Added
                employeeDto.getDepartmentCode()
                );
        //save
        Employee savedEmployee=employeeRepository.save(employee);
        //convert dto to jpa
        EmployeeDto savedEmployeeDto=new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
//                added
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    //create get method
    @Override
//    public EmployeeDto getEmployeeById(Long employeeId) {
    public APIResponseDto getEmployeeById(Long employeeId) {


        Employee employee=employeeRepository.findById(employeeId).get();

        //added for microservices
       /* ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode()
                , DepartmentDto.class);
                DepartmentDto departmentDto=responseEntity.getBody();
                */
        //webclient
        //uncomment this one for circuit braker
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
//comment these for circuit braker
      // DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
        //convert
        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
//                added
                employee.getDepartmentCode()
        );
        //after ApiResponseDto create
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

//        return employeeDto;
        return apiResponseDto;
    }
//added for circuit breaker this method copy and paste from above line
    //added later Exception exception in parameter
// if we do not passed also no issue i faced depends if got error then pass parameter
    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        Employee employee=employeeRepository.findById(employeeId).get();

        //added new fallback method implementation
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("R001");
        departmentDto.setDepartmentDescription("Research & Development Department");


        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
//                added
                employee.getDepartmentCode()
        );
        //after ApiResponseDto create
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

//        return employeeDto;
        return apiResponseDto;

    }
}
