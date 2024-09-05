package net.javaguides.departmentservice.Mapper;

import net.javaguides.departmentservice.Dto.DepartmentDto;
import net.javaguides.departmentservice.Model.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    return departmentDto;
    }
    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
