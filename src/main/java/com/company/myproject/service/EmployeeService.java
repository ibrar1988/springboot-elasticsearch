package com.company.myproject.service;

import org.json.simple.JSONObject;

public interface EmployeeService {
	
	String doLogin(JSONObject request);

	JSONObject getEmpById(Long empId, String empName);
}
