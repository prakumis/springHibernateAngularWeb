package edu.springweb.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Praveen
 * 
 */
public class SecurityUtils {

	/**
	 * Returns the name (userName) of the logged-in user who is currently executing this
	 * code
	 * 
	 * @return
	 */
	public static String getCurrentUserName() {
		String username = null;

		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null)
			return username;

		Authentication authentication = securityContext.getAuthentication();
		if (authentication == null)
			return username;

		Object principal = authentication.getPrincipal();
		if (principal == null)
			return username;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return username;
	}
	
}
