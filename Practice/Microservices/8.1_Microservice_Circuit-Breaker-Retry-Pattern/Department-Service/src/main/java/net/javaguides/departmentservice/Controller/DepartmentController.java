package net.javaguides.departmentservice.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.Dto.DepartmentDto;
import net.javaguides.departmentservice.Model.Department;
import net.javaguides.departmentservice.Repository.DepartmentRepository;
import net.javaguides.departmentservice.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    //autowired
    private DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    //Build save department Rest-Api
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.OK);
    }

    //Get Mappings getDepartmentByCode
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}