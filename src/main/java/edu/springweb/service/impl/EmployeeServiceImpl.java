/**
 * 
 */
package edu.springweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import edu.springweb.dao.EmployeeDao;
import edu.springweb.entity.Employee;
import edu.springweb.service.EmployeeService;

/**
 * @author Praveen
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Inject
	private EmployeeDao employeeDao;

	//@Transactional(readOnly=true)
	public List<Employee> getAll() {

		logger.debug("Entered getAll()");
		List<Employee> empList = employeeDao.getEmployees();

		return empList;
	}


	//@Transactional
	public void save(Employee emp) {

		employeeDao.save(emp);
	}


	//@Transactional(readOnly=true)
	public Employee getEmpById(Long id) {

		if(id==null || id==0) {
			return null;
		} else {
			return employeeDao.getById(id);
		}
	}


	//@Transactional
	public Long getNextEmpId() {

		return employeeDao.getNextEmpId();
	}


	//@Transactional
	public Employee deleteById(Long empId) {

		return employeeDao.deleteById(empId);
	}
}
