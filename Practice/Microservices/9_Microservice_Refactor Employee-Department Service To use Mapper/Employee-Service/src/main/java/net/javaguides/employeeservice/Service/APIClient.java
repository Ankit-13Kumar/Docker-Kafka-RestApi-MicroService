package net.javaguides.employeeservice.Service;

import net.javaguides.employeeservice.Dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//for two instance configuration for load balancing
//@FeignClient(url = "http://localhost:8080:http://localhost:8082",name = "Department")
@FeignClient(url = "http://localhost:8080",name = "Department")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}