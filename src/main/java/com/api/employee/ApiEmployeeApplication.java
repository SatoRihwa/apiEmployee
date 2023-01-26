package com.api.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.api.employee.controller.EmployeeController;


@SpringBootApplication
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.api.employee.bean"})
@ComponentScan(basePackageClasses = EmployeeController.class)
public class ApiEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEmployeeApplication.class, args);
	}

}
