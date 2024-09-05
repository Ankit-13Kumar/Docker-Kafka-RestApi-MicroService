package net.javaguides.departmentservice.Repository;

import net.javaguides.departmentservice.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
Department findByDepartmentCode(String departmentCode);
}
