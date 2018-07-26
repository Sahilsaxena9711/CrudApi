package org.api.Controller;

import org.api.Entity.Employee;
import org.api.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET )
    public Collection<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmloyeeById(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployeeById(@PathVariable("id") int id){
        return employeeService.deleteEmployeeById(id);
    }
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployeeById(@RequestBody Employee employee){
        employeeService.updateEmployeeById(employee);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee){
        employeeService.insertEmployee(employee);
    }
}
