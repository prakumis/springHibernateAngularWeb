package edu.springweb.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Extension of {@code UsernamePasswordAuthenticationFilter} customized to fetch
 * the domain information from the provided principal/userName. Principal expected
 * in this format : mydomain\praveen
 * 
 * @author praveen
 * 
 */
public class ActiveDirectoryAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	// ~ Constructors
	// ===================================================================================================

	public ActiveDirectoryAuthenticationFilter() {
		super();
	}

	// ~ Methods
	// ========================================================================================================

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}

		String username = obtainUsername(request);
		String domain = obtainDomain(request);
		String password = obtainPassword(request);
		verifyApplication(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}
		
		if(domain == null){
			domain = "";
		}

		username = username.trim();
		domain = domain.trim();

		UsernamePasswordAuthenticationToken authRequest = new ActiveDirectoryAuthenticationToken(username, password, domain);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * The application id is not technically required to authenticate a user
	 * but is more of mandatory application specific information. Without it, 
	 * there is no point in authenticating the user.
	 * @param request
	 */
	private void verifyApplication(HttpServletRequest request) {
		String applicationId = request.getParameter("application.id");
		if (applicationId == null || applicationId.isEmpty()) {
			throw new BadCredentialsException("Invalid application selection");
		}

		try {
			Long.parseLong(applicationId);
		} catch (NumberFormatException ex) {
			throw new BadCredentialsException("Invalid Application Id");
		}
		
		//TODO - Verify against Application table
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String domainWithUsername = request.getParameter(getUsernameParameter());
		if (domainWithUsername.matches("^[a-z]{1,}\\\\e[a-z]{6}$")) {
			String[] tokens = domainWithUsername.split("\\\\");
			return tokens[1];
		}
		return domainWithUsername;
	}

	protected String obtainDomain(HttpServletRequest request) {
		String domainWithUsername = request.getParameter(getUsernameParameter());
		if (domainWithUsername.matches("^[a-z]{1,}\\\\e[a-z]{6}$")) {
			String[] tokens = domainWithUsername.split("\\\\");
			return tokens[0];
		}
		return null;
	}

}
