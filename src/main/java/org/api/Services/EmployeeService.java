package org.api.Services;

import org.api.Dao.EmployeeDao;
import org.api.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("realData")
    private EmployeeDao employeeDao;

    public Collection<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

    public Employee getEmloyeeById(int id){
        return this.employeeDao.getEmloyeeById(id);
    }

    public Employee deleteEmployeeById(int id) {
        return this.employeeDao.deleteEmployeeById(id);
    }
    public void updateEmployeeById(Employee employee){
        this.employeeDao.updateEmployeeById(employee);
    }

    public void insertEmployee(Employee employee) {
        this.employeeDao.insertEmployee(employee);
    }
}
