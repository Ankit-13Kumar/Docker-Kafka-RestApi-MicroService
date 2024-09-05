package net.javaguides.departmentservice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.Dto.DepartmentDto;
import net.javaguides.departmentservice.Model.Department;
import net.javaguides.departmentservice.Repository.DepartmentRepository;
import net.javaguides.departmentservice.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "    Department-Controller",
        description = "Crud Operation for Department Service"
)
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    //autowired
    private DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    //Build save department Rest-Api
    //Opeartion Description
    @Operation(
            summary = "Post request to create Department-Service",
            description = "Creating Department and saved it to database"
    )
    //Provide RestAPI Response
    @ApiResponse(
            responseCode = "201 created",
            description = "Created status 201 Department"
    )
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.OK);
    }

    //Get Mappings getDepartmentByCode
    //Opeartion Description
    @Operation(
            summary = "Get request to Fetch Department",
            description = "Get Department From database"
    )
    //Provide RestAPI Response
    @ApiResponse(
            responseCode = "200 Success",
            description = "HTTP status 200 Success"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}