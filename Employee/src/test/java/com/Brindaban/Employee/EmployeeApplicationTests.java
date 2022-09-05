package com.Brindaban.Employee;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.Brindaban.Employee.Entity.Employee;
import com.Brindaban.Employee.Repository.EmployeeRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class EmployeeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setup() {
		employeeRepository.deleteAll();
	}

	@Test
	public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
		// given Precondition or setup
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employee("Dilip Ghosh", 28000, "Male", 24, 2));
		listOfEmployees.add(new Employee("Arya Maji", 30000, "Female", 26, 2));
		listOfEmployees.add(new Employee("Biswajit Nandi", 25000, "Male", 25, 1));
		listOfEmployees.add(new Employee("Salini Roy", 31000, "Female", 27, 3));
		listOfEmployees.add(new Employee("Rohit Das", 26000, "Male", 23, 3));

		employeeRepository.saveAll(listOfEmployees);

		// when - action or the behavior that we are going test
		ResultActions response = mockMvc.perform(get("http://localhost:9078/employee"));

		// then - verify the output
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfEmployees.size())));
	}
}