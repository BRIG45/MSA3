package com.Brindaban.Department.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Brindaban.Department.VO.RequestTemplate;
import com.Brindaban.Department.Entity.Department;
import com.Brindaban.Department.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService depatService;

	@PostMapping
	public Department add(@RequestBody Department dept) {
		return depatService.add(dept);
	}

	@GetMapping
	public List<Department> list() {
		return depatService.list();
	}

	@GetMapping("/{id}")
	public Department searchById(@PathVariable long id) {
		return depatService.searchById(id);
	}

	@GetMapping("/all-department-employee")
	public List<RequestTemplate> listWithEmp() {
		return depatService.listWithEmp();
	}

	@GetMapping("/department-with-employee/{dept_id}")
	public RequestTemplate specificDeptEmp(@PathVariable long dept_id) {
		return depatService.specificDeptEmployee(dept_id);
	}
}