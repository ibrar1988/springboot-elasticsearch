package com.company.myproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.myproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query("Select e From Employee e where e.id=:id")
	Employee getEmpById(@Param("id") Long id);
	
	@Query("Select e From Employee e")
	List<Employee> getEmpList();
}
