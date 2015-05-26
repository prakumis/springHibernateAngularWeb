/**
 * 
 */
package edu.springweb.web;

import java.security.Principal;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.springweb.entity.Role;
import edu.springweb.entity.User;
import edu.springweb.exception.ServiceException;
import edu.springweb.service.UserService;
import edu.springweb.web.security.SecurityUtils;

/**
 * @author Praveen
 *
 */
@Controller
public class LoginController {

	public static final Logger logger = Logger.getLogger(LoginController.class);

	@Inject
	private UserService userService;

	@RequestMapping("/")
	public String init(Model model){

		logger.info("Init LoginController Invoked");
		// do something here
		return "login";
	}

	@RequestMapping("/login1")
	public void login1() throws Exception {
		System.out.println("inside login");
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		// request.getSession().invalidate();

		System.out.println("inside login from mkyong: "+error);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("message", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("message", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping("/accessDenied")
	public void accessDenied() throws Exception {
	}

	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
	public String logoutSuccess(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		model.addAttribute("message", "You have successfully logged out");
		return "login";
	}

	@RequestMapping(value = "/login/failure")
	public String loginFailure(Model model) throws Exception {
		model.addAttribute("message", "Invalid Username and Password resulting failure");
		System.out.println("inside login failure");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		System.out.println("inside logout");
		sessionStatus.setComplete();
		request.getSession().invalidate();
		model.addAttribute("message", "You have successfully logged out");
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String postLogin(HttpSession session, HttpServletRequest request, Principal principal) {

		logger.debug("LoggedIn User Info Available : " + session.getAttribute("loggedInUser"));

		if (session.getAttribute("loggedInUser") == null) {
			//User loggedInUser = fetchUser_OLD(principal);
			User loggedInUser = fetchUser();
			if (loggedInUser == null) {
				// TODO - check if forward can be used instead of redirect
				return "redirect:logout";
			}
			session.setAttribute("loggedInUser", loggedInUser);
			Collection<Role> roles = fetchRoles(loggedInUser);
			session.setAttribute("roles", roles);
		}
		return "welcomeHome";
	}

	private Collection<Role> fetchRoles(User loggedInUser) {

		Collection<Role> roles = null;
		try {
			roles = getUserService().findRolesForUser(loggedInUser);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("LoggedInUser Roles : " + roles);

		return roles;
	}

	private User fetchUser() {
		User loggedInUser = new User();
		loggedInUser.setUserName(SecurityUtils.getCurrentUserName());
		try {
			// Check if user exists in the system and is 'ACTIVE'
			loggedInUser = getUserService().findActiveUser(loggedInUser);
			//loggedInUser.setRoleAndATAssignments(null);
			//loggedInUser.setRecordInfo(null);
			return loggedInUser;
		} catch (ServiceException ex) {
			logger.warn("Invalid User : " + loggedInUser.getUserName());
			return null;
		}
	}

	private User fetchUser_OLD(Principal principal) {

		User loggedInUser = new User();
		String name = principal.getName(); // get logged in username
		loggedInUser.setUserName(name);
		try {
			// Check if user exists in the system and is 'ACTIVE'
			loggedInUser = getUserService().findActiveUser(loggedInUser);
			return loggedInUser;
		} catch (ServiceException ex) {
			logger.warn("Invalid User : " + loggedInUser.getUserName());
			return null;
		}
	}

	public UserService getUserService() {
		return userService;
	}
}
