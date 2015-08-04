package edu.springweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	// Configurable origin for CORS - default: * (all)
	@Value("${http.filter.cors.origin:*}")
	private String origin;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		System.out.println("Entered doFilter() of SimpleCORSFilter &&&&&");
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		System.out.println("Before SimpleCORSFilter.doFilter");
		System.out.println("contentType: " + req.getContentType());
		chain.doFilter(req, res);
		System.out.println("After SimpleCORSFilter.doFilter");
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}