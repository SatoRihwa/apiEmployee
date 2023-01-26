package com.api.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.employee.bean.Employee;
import com.api.employee.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> employeeGet() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee employeeGetById(@PathVariable String id) {
		Optional<Employee> target = employeeRepository.findById(Integer.parseInt(id));
		return target.get();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
    public List<Employee> employeePost(
            @RequestBody List<Employee> loggerList) {

        List<Employee> result = employeeRepository.saveAll(loggerList);
        return result;
    }
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public Employee employeePut(@RequestBody Employee employee){
        Optional<Employee> target = employeeRepository.findById(employee.getId());
        if(target.isEmpty()) {
            return null;
        } else {
        	employeeRepository.save(employee);
            return target.get();
        }
    }
	
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    public String employeeDelete(@RequestBody Employee project) {
        Optional<Employee> target = employeeRepository.findById(project.getId());
        if(target.isEmpty()) {
            return null;
        } else {
        	employeeRepository.deleteById(target.get().getId());
            return "OK";
        }
    }
}
