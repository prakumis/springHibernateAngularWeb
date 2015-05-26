/**
 * 
 */
package edu.springweb.web;

import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.springweb.entity.Employee;
import edu.springweb.service.EmployeeService;

/**
 * @author Praveen
 *
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

	public static final Logger logger = Logger.getLogger(EmployeeController.class);

	@Inject
	private EmployeeService employeeService;

	//private Validator validator;

	public EmployeeController() {
		//ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		//validator = validatorFactory.getValidator();
	}

	@RequestMapping("/")
	public String getAll(Model model, HttpServletRequest request) {

		logger.debug("Entered EmployeeController");
		Collection<Employee> empList = employeeService.getAll();
		model.addAttribute("empList", empList);
		model.addAttribute("message", "Employee list is available");
		// request.setAttribute("empList", empList);
		request.setAttribute("messgae", "Praveen is working on JSON");
		return "empHome";
	}

	@ResponseBody
	@RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	public Collection<Employee> getAllEmp(Model model, HttpServletRequest request) {

		Collection<Employee> empList = employeeService.getAll();
		model.addAttribute("empList", empList);
		request.setAttribute("empList", empList);
		request.setAttribute("messgae", "Praveen is working on JSON");
		Employee emp = new Employee();
		emp.setFirstName("Praveen Kumar ");
		emp.setLastName("Mishra");
		return empList;
		// return "jsonTemplate";
	}

	@RequestMapping("/view/{empId}")
	public String getEmpById(Model model, HttpServletRequest request, @PathVariable Long empId) {

		logger.debug("Entered EmployeeController.view/{empId}");
		Employee emp = employeeService.getEmpById(empId);
		model.addAttribute("emp", emp);
		return "viewEmp";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {

		Employee emp = new Employee();
		//emp.setId(employeeService.getNextEmpId());
		model.addAttribute("emp", emp);
		return "editEmp";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request, @RequestParam Long empId) {

		System.out.println("Emp Id to be edited: "+empId);
		Employee emp = employeeService.getEmpById(empId);
		model.addAttribute("emp", emp);
		return "editEmp";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, HttpServletRequest request, @ModelAttribute("emp") @Valid Employee emp,
			BindingResult bindingResult) {

		/*Set<ConstraintViolation<Employee>> violations = validator.validate(emp);
		for (ConstraintViolation<Employee> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			// Add JSR-303 errors to BindingResult
			// This allows Spring to display them in view via a FieldError
			//bindingResult.addError(new FieldError("employee", propertyPath,	"Invalid " + propertyPath + "(" + message + ")"));
		}*/
		if (bindingResult.hasErrors()) {

			/*List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
			}*/
			//model.addAttribute("emp", emp);
			return "editEmp";
		}

		System.out.println("no error");
		employeeService.save(emp);
		model.addAttribute("successMessage", "Employee details is saved successfully in system");
		model.addAttribute("emp", emp);
		return "viewEmp";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request, @RequestParam Long empId) {

		System.out.println("Emp Id to be deleted: "+empId);
		Employee emp = employeeService.deleteById(empId);
		model.addAttribute("emp", emp);
		model.addAttribute("successMessage", "Employee details is deleted successfully from system");
		request.setAttribute("", "");
		return "viewEmp";
	}

	/**
	 * @return the employeeService
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * @param employeeService
	 *            the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
