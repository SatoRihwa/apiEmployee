package com.api.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.employee.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
