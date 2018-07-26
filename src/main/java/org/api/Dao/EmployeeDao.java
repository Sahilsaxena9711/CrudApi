package org.api.Dao;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import org.api.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;

    static{
        employees = new HashMap<Integer, Employee>(){
            {
                put(1, new Employee(1, "Sahil","Developer"));
                put(2, new Employee(2, "Mendok","HR"));
                put(3, new Employee(3, "Nitin","Manager"));
                put(4, new Employee(4, "Rishi","Accountant"));
            }
        };
    }
    public Collection<Employee> getAllEmployee(){
        return this.employees.values();
    }
    public Employee getEmloyeeById(int id){
        return this.employees.get(id);
    }
    public Employee deleteEmployeeById(int id) {
        return this.employees.remove(id);
    }
    public void updateEmployeeById(Employee employee){
        Employee emp = employees.get(employee.getId());
        emp.setName(employee.getName());
        emp.setDesignation((employee.getDesignation()));
        employees.put(employee.getId(), employee);
    }
    public void insertEmployee(Employee employee) {
        this.employees.put(employee.getId(), employee);
    }
}
