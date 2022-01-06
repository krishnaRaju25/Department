package com.example.springprogrms.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.springprogrms.demo.controller.DepartmentController;
import com.example.springprogrms.demo.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeController employeeController;

	@Autowired
	private DepartmentController departmentController;
	// positive test case
	@Test
	public void testGetEmpById() {
		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = employeeController.getEmpById(1).getStatusCode(); // 200
		assertEquals(expected, actual);
	}

	// negative test case
	@Test
	public void testGetEmpById2() {
		HttpStatus unexpected = HttpStatus.NOT_FOUND;
		HttpStatus actual = employeeController.getEmpById(1).getStatusCode(); // 200
		assertNotEquals(unexpected, actual);
	}

	@Test
	public void getDepId()
	{
		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = departmentController.getDepById(10).getStatusCode();
		assertEquals(expected,actual);

	}
}
