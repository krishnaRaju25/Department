package com.example.springprogrms.demo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import antlr.build.Tool;
import com.example.springprogrms.demo.Repository.EmployeeRepository;
import com.example.springprogrms.demo.controller.EmployeeController;
import com.example.springprogrms.demo.model.Department;
import com.example.springprogrms.demo.model.Employee;
import com.example.springprogrms.demo.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTests {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeControllerTests.class);

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;
    @Autowired
    MockMvc mockMvc;
    private static List<Employee> empList;

    @BeforeAll
    public static void createEmpData() {
        empList = new ArrayList<>();
        empList.add(new Employee("Sonu", 25000, new Department(10)));
        empList.add(new Employee("Monu", 35000, new Department(20)));
        empList.add(new Employee("Tonu", 30000, new Department(20)));
    }

//    @Test
//    public void testGetAllEmployees() {
//
//        when(repository.findAll()).thenReturn(empList);
//
////		List<Employee> empList2 = service.getAllEmployees();
//
//        assertEquals(3, service.getAllEmployees().size());
//
//    }
  //  @Test
//    public void testGetAllEmployeesTimes() {
//        when(repository.findAll()).thenReturn(empList);
//        service.getAllEmployees();
//        service.getAllEmployees();
//        service.getAllEmployees();
//        verify(repository, times(3)).findAll();
//    }
    public void testGetAllEmployees() throws Exception {
        LOG.info("testGetAllEmployees");
        when(service.getAllEmployees()).thenReturn(empList);

        mockMvc.perform(get("/emplist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

}