package com.company.myproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.myproject.model.Employee;
import com.company.myproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository er;
	
	@Transactional
	@Override
	public String doLogin(JSONObject request) {
		String response="";
		try {
			
			Employee e = er.getEmpById(1l);
			List<Employee> empList=er.getEmpList();
			for(Employee emp:empList) {
				System.out.println(emp.getEmpName());
			}
			if(e!=null) {
				e.setEmpName("samir verma");
				er.save(e);
			}
			/*e.setEmpName("Ibrar husian");
			e.setEmpAddress("Ibra Address");
			er.save(e);*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public JSONObject getEmpById(Long empId, String empName) {
		JSONObject response=new JSONObject();
		try {
			Employee e = er.getEmpById(empId);
			JSONObject empJsonObj=new JSONObject();
			empJsonObj.put("name", e.getEmpName());
			empJsonObj.put("address", e.getEmpAddress());
			empJsonObj.put("id", e.getId());
			response.put("empData", empJsonObj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
