package com.albasha.springrestapi.controller;

import com.albasha.springrestapi.model.Employee;
import com.albasha.springrestapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller + @ResponseBody = @RestController
//mapping the controller to the url /api/v1 to be used in the browser to send requests to the controller layer (presentation layer)
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    //localhost:8080/api/v1/employees
    //injecting the service layer to the controller layer using @Autowired annotation (Dependency Injection)
    @Autowired
    private EmployeeService eService;

    //injecting values from application.properties
    /*@Value("${app.name}")
    private String appName;

    //injecting values from application.properties
    @Value("${app.version}")
    private String appVersion;

    //get the app details from the application.properties
    @GetMapping("/version")
    public String getAppDetails() {
        return appName + " : " + appVersion;
    }*/
    //localhost:8080/employees

    //get employees from the database and display them in the browser as a response to the request from the client side (browser)
    //@RequestMapping(value = "/employees", method = RequestMethod.GET) +post +put +delete = @GetMapping
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
    }

    //get employee with id = 12 from the database and display it in the browser as a response to the request from the client side (browser)
    //localhost:8080/employees/12
    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployee(@PathVariable long id) {
        return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
    }
    //save the employee details to the database and display it in the browser as a response to the request from the client side (browser)
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //update the employee details in the database and display it in the browser as a response to the request from the client side (browser)
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
    }
    //delete the employee with id = 12 from the database and display it in the browser as a response to the request from the client side (browser)
    //localhost:8080/employees?id=12
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam long id) {
         return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByNamesAndLocation(@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(eService.getEmployeeByNamesAndLocation(name, location), HttpStatus.OK);
    }
}
