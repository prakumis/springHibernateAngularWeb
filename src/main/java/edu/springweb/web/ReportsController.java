/**
 * 
 */
package edu.springweb.web;

import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.springweb.entity.Employee;
import edu.springweb.service.EmployeeService;

/**
 * @author Praveen
 *
 */
@Controller
@RequestMapping("/reports")
public class ReportsController {

	public static final Logger logger = Logger.getLogger(ReportsController.class);

	@Inject
	private EmployeeService employeeService;

	@RequestMapping("/getEmployeeList")
	public String getEmployeeList(Model model, HttpServletRequest request) {

		// set role in request/session for the user
		//request.
		Collection<Employee> empList = employeeService.getAll();
		model.addAttribute("empList", empList);
		request.setAttribute("empList", empList);
		request.setAttribute("messgae", "Praveen is working on JSON");
		Employee emp = new Employee();
		emp.setFirstName("Praveen Kumar ");
		emp.setLastName("Mishra");
		return "emp/empList";
	}

	/**
	 * @return the employeeService
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * @param employeeService the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
