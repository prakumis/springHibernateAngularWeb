package edu.springweb.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Authentication token specific for Active Directory authentication. The token
 * consists of the domain information of the user along with his principal and
 * credentials
 * 
 * @author Praveen
 * 
 */
public class ActiveDirectoryAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8932633434921549312L;

	private String domain;

	public ActiveDirectoryAuthenticationToken(Object principal, Object credentials,
			String domain) {
		super(principal, credentials);
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

}
