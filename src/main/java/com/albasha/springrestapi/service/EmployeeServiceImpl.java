package com.albasha.springrestapi.service;

import com.albasha.springrestapi.model.Employee;
import com.albasha.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//injecting the service layer to the controller layer using @Service annotation (Dependency Injection)
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository eRepository;
    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }
    @Override
    public Employee getSingleEmployee(long id) {

        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
    }
        else{
            throw new RuntimeException("Employee not found for the id: "+id);
        }
    }
    @Override
    public void deleteEmployee(long id) {
        eRepository.deleteById(id);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNamesAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }
}
