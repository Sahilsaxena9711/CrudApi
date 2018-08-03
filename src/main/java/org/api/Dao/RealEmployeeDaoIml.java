package org.api.Dao;

import org.api.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("realData")
public class RealEmployeeDaoIml implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class EmployeeRowMapper implements RowMapper<Employee>{

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setDesignation(resultSet.getString("designation"));
            return employee;
        }
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        final String sql = "SELECT id, name, designation FROM employee";
        List<Employee> employee = jdbcTemplate.query(sql,new EmployeeRowMapper());
                return employee;
    }

    @Override
    public Employee getEmloyeeById(int id) {
        final String sql = "SELECT id, name, designation FROM employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        jdbcTemplate.update("DELETE FROM employee where id = ?", id);
    }

    @Override
    public void updateEmployeeById(Employee employee, int id) {
        final String sql = "UPDATE employee SET name = ?, designation = ? WHERE id = ?";
        final String name = employee.getName();
        final String designation = employee.getDesignation();
        jdbcTemplate.update(sql, new Object[]{name, designation, id});
    }

    @Override
    public void insertEmployee(Employee employee) {
        final String sql = "INSERT INTO employee (name, designation) values(?, ?)";
        final String name  = employee.getName();
        final String designation = employee.getDesignation();
        jdbcTemplate.update(sql, new Object[]{name, designation});
    }
}
