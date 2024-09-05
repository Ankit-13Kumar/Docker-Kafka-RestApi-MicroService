package net.javaguides.departmentservice.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.Dto.DepartmentDto;
import net.javaguides.departmentservice.Mapper.DepartmentMapper;
import net.javaguides.departmentservice.Model.Department;
import net.javaguides.departmentservice.Repository.DepartmentRepository;
import net.javaguides.departmentservice.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa
       /* Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );*/
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        //Save and convert then return original one
        Department savedDepartment=departmentRepository.save(department);
//convert department jpa to department dto
/*DepartmentDto savedDepartmentDto=new DepartmentDto(
        savedDepartment.getId(),
        savedDepartment.getDepartmentName(),
        savedDepartment.getDepartmentDescription(),
        savedDepartment.getDepartmentCode()
);*/
        DepartmentDto savedDepartmentDto=DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        //for that one write query in repository
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        //convert
        /*DepartmentDto departmentDto=new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );*/
        DepartmentDto departmentDto=DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
