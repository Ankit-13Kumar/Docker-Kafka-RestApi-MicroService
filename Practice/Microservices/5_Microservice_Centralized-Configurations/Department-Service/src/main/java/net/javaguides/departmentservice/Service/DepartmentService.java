package net.javaguides.departmentservice.Service;

import net.javaguides.departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
    //Declared methods
    //Save department
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
     //Get department each department has unique code
    DepartmentDto getDepartmentByCode(String code);

}
