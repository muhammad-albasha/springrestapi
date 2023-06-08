package com.albasha.springrestapi.service;

import com.albasha.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    //get employees from the database and display them in the browser as a response to the request from the client side (browser) in the service layer (business logic) and the controller layer (presentation layer)
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(long id);
    void deleteEmployee(long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee>  getEmployeeByNamesAndLocation(String name, String location);
}
