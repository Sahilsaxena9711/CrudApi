package org.api.Dao;

import org.api.Entity.Employee;

import java.util.Collection;

public interface EmployeeDao {
    Collection<Employee> getAllEmployee();

    Employee getEmloyeeById(int id);

    Employee deleteEmployeeById(int id);

    void updateEmployeeById(Employee employee);

    void insertEmployee(Employee employee);
}
