package net.javaguides.employeeservice.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.Dto.EmployeeDto;
import net.javaguides.employeeservice.Model.Employee;
import net.javaguides.employeeservice.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    //autowited auto inject
    private EmployeeService employeeService;


    //Build save Api Post
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //get employee

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}
