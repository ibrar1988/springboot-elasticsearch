package com.company.myproject.controller;

import javax.websocket.server.PathParam;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.myproject.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class LoginController {
	
	@Autowired
	private EmployeeService es;
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	String doLogin(@RequestBody JSONObject loginInfo) {
		
		String response=es.doLogin(loginInfo);
		return "SUzuki Access 125 BS6";
	}
	
	@RequestMapping(value="/empById",method=RequestMethod.GET)
	JSONObject doLogin(@RequestParam("empId") String empId,@RequestParam("empName") String empName) {
		System.out.print("Emp Id===>"+empId+"  "+empName);
		JSONObject response=es.getEmpById(Long.parseLong(empId),empName);
		return response;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	String logout() {
		return "login success@@@@@";
	}

}
