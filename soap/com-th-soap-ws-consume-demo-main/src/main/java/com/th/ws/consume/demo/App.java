
package com.th.ws.consume.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	CommandLineRunner lookup(EmployeeClient quoteClient) {
		return args -> {

			GetEmployeeResponse response = quoteClient.getEmployee(101);
			LOG.info(response.getEmployeeType().getEmployeeId() + " " + response.getEmployeeType().getFirstName() + " "
					+ response.getEmployeeType().getSalary());

			//salary
			GetEmployeeResponse salaryresponse = quoteClient.getEmployeeSalaryRequest(54000d);
			LOG.info(salaryresponse.getEmployeeType().getEmployeeId() + " " + salaryresponse.getEmployeeType().getFirstName() + " "
					+ salaryresponse.getEmployeeType().getSalary());

			GetAllEmployeesResponse response2 = quoteClient.getAllEmployees();
			response2.getEmployeeType()
					.forEach(obj -> LOG.info(obj.employeeId + " " + obj.firstName + " " + obj.salary));



			GetEmployeeResponse response3 = quoteClient.addEmployee();
//			LOG.info(response3.getEmployeeType().getEmployeeId() + " " + response3.getEmployeeType().getFirstName()
//					+ " " + response3.getEmployeeType().getSalary());

		};
	}
}
