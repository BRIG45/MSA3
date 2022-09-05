package com.Brindaban.Department.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Brindaban.Department.VO.RequestTemplate;
import com.Brindaban.Department.Entity.Department;

@Service

public interface DepartmentService {
	Department add(Department dept);

	List<Department> list();

	Department update(long id, String name);

	Department searchById(long id);

	List<RequestTemplate> listWithEmp();

	RequestTemplate specificDeptEmployee(long dept_id);
}