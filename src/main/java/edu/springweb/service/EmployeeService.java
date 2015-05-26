/**
 * 
 */
package edu.springweb.service;

import java.util.List;


import org.springframework.security.access.prepost.PreAuthorize;

import edu.springweb.entity.Employee;

/**
 * @author Praveen
 *
 */
@PreAuthorize("hasRole('REPORT_ADMIN') or hasRole('ROLE_ADMIN')")
public interface EmployeeService {

	//@PreAuthorize("hasRole('REPORT_ADMIN') and hasRole('ALL_ADMIN')")
	public List<Employee> getAll();

	public void save(Employee emp);

	public Employee getEmpById(Long id);

	public Long getNextEmpId();

	public Employee deleteById(Long empId);
}
