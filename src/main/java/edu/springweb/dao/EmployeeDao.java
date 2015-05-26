/**
 * 
 */
package edu.springweb.dao;

import java.util.List;

import edu.springweb.entity.Employee;

/**
 * @author Praveen
 *
 */
public interface EmployeeDao {

	public List<Employee> getEmployees();

	public void save(Employee emp);

	public Employee getById(Long id);

	public Long getNextEmpId();

	public Employee deleteById(Long empId);

}
