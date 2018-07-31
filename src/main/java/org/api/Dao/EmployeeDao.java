package org.api.Dao;

import org.api.Entity.Employee;

import java.util.Collection;

public interface EmployeeDao {
    Collection<Employee> getAllEmployee();

    Employee getEmloyeeById(int id);

    void deleteEmployeeById(int id);

    void updateEmployeeById(Employee employee, int id);

    void insertEmployee(Employee employee);
}
