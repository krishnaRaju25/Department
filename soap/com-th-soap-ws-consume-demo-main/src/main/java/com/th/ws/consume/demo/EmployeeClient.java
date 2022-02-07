package com.th.ws.consume.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class EmployeeClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);

	// getBySalary, updateEmployee, deleteEmployee

	public GetEmployeeResponse getEmployee(int employeeId) {
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setEmployeeId(employeeId);
		log.info("Requesting ... " + employeeId);
		GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8099/ws/employees", request,
				new SoapActionCallback("https://www.torryharris.com/soap-ws-demo/GetEmployeeRequest"));
		return response;
	}

//salary
	public GetEmployeeResponse getEmployeeSalaryRequest(double salary)
	{
		GetEmployeeSalaryRequest getEmployeeSalaryRequest=new GetEmployeeSalaryRequest();
		getEmployeeSalaryRequest.setSalary(salary);
		log.info("Requesting salary  "+salary );
		GetEmployeeResponse response= (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8099/ws/employees", getEmployeeSalaryRequest,
				new SoapActionCallback("https://www.torryharris.com/soap-ws-demo/GetEmployeeRequest"));
		return response;
	}

	//public AddEmployeeRequest
	public GetAllEmployeesResponse getAllEmployees() {
		GetAllEmployeesRequest request = new GetAllEmployeesRequest();
		log.info("Requesting ... ");
		GetAllEmployeesResponse response = (GetAllEmployeesResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8099/ws/employees", request,
				new SoapActionCallback("https://www.torryharris.com/soap-ws-demo/GetEmployeeRequest"));
		return response;
	}

	public GetEmployeeResponse addEmployee() {
		AddEmployeeRequest request = new AddEmployeeRequest();
		request.setEmployeeId(107);
		request.setFirstName("Bonu");
		request.setSalary(64000);

		log.info("Requesting ... ");
		GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8099/ws/employees", request,
				new SoapActionCallback("https://www.torryharris.com/soap-ws-demo/GetEmployeeRequest"));
		return response;
	}

}