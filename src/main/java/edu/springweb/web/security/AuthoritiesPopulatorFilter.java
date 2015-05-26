package edu.springweb.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.commons.api.commons.utils.StringUtils;
import edu.springweb.entity.Role;
import edu.springweb.entity.RoleOperationAssignment;
import edu.springweb.exception.ServiceException;
import edu.springweb.service.RoleOperationAssignmentService;

/**
 * Custom Filter that loads authorities in the {@link Authentication} object
 * based on the selected role
 * 
 * @author Praveen
 * 
 */
public class AuthoritiesPopulatorFilter implements Filter {

	private static Logger logger = LoggerFactory
			.getLogger(AuthoritiesPopulatorFilter.class);

	private RoleOperationAssignmentService roleOperationService;

	public void init(FilterConfig config) throws ServletException {
		logger.debug("Init Invoked");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		// TODO - handle number format exception
		String userRole = request.getParameter("userRole");
		if(StringUtils.isNullOrBlank(userRole)) {
			userRole = "1";
		}
		try {
			Long roleId = Long.parseLong(userRole);
			logger.debug("Selected Role : " + roleId);
			
			// Load Authorities for the selected role
			//TODO - load authorities before reaching the LoginController
			RoleOperationAssignment roleOperation = new RoleOperationAssignment();
			Role role = new Role();
			role.setId(roleId);
			roleOperation.setRole(role);
			//roleOperation.setStatus(Status.ACTIVE);

			Collection<RoleOperationAssignment> roleOperations = getRoleOperationService().findRoleAndOperations(roleOperation);

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
			for (RoleOperationAssignment localRoleOperation : roleOperations) {
				role = localRoleOperation.getRole();
				authorities.add(new SimpleGrantedAuthority(role.getName()));
				logger.debug("Assigned the Role ["+role.getName()+"]");
				if (localRoleOperation.getOperation() != null) {
					logger.debug("Assigned the Function ["+localRoleOperation.getOperation().getName()+"]");
					authorities.add(new SimpleGrantedAuthority(
							localRoleOperation.getOperation().getName()));
				}
			}
			
			//authorities.add(new SimpleGrantedAuthority("SUPER_ADMIN"));

			// Build a new Authentication object
			updateSecurityContext(authorities);
			
			// Delegate to next filter in the chain
			filterChain.doFilter(request, response);
			
		} catch (NumberFormatException ex) {
			logger.error("Invalid Request Parameter 'userRole' : " + userRole);
			
			// Build a new Authentication object with no authorities
			updateSecurityContext(AuthorityUtils.NO_AUTHORITIES);
						
			// request dispatch to view 'welcome'
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("welcome");
			requestDispatcher.forward(request, response);
		}

		catch (ServiceException ex) {
			logger.warn("Error Occurred while fetching Operations for Role, hence NO AUTHORITIES");
			// Build a new Authentication object with no authorities
			updateSecurityContext(AuthorityUtils.NO_AUTHORITIES);
		}

	}

	private void updateSecurityContext(List<GrantedAuthority> authorities) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		securityContext
				.setAuthentication(new UsernamePasswordAuthenticationToken(
						authentication.getPrincipal(), authentication
								.getCredentials(), authorities));
	}

	public void destroy() {
		logger.debug("Destroy Invoked");
	}

	public RoleOperationAssignmentService getRoleOperationService() {
		return roleOperationService;
	}

	public void setRoleOperationService(
			RoleOperationAssignmentService roleOperationService) {
		this.roleOperationService = roleOperationService;
	}

}
