package net.javaguides.employeeservice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.Dto.APIResponseDto;
import net.javaguides.employeeservice.Dto.EmployeeDto;
import net.javaguides.employeeservice.Model.Employee;
import net.javaguides.employeeservice.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "    Employee-Controller",
        description = "Crud Operation for Employee Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    //autowited auto inject
    private EmployeeService employeeService;


    //Build save Api Post
    @Operation(
            summary = "Post request to create Employee-Service",
            description = "Creating Employee and saved it to database"
    )
    //Provide RestAPI Response
    @ApiResponse(
            responseCode = "201 created",
            description = "Created status 201 Employee"
    )
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //get employee

//   public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){
//        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
//        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
//    }
    //Changing DTO type
@Operation(
        summary = "Get request to Fetch Employee",
        description = "Get Employee From database"
)
//Provide RestAPI Response
@ApiResponse(
        responseCode = "200 Success",
        description = "HTTP status 200 Success"
)
   @GetMapping("/{id}")
   public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
