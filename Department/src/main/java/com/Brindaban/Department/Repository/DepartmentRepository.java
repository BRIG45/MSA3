package com.Brindaban.Department.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Brindaban.Department.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findById(long id);
}