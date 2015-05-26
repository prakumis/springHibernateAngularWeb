package edu.springweb.service;

import java.util.Collection;

import edu.springweb.entity.Role;
import edu.springweb.entity.User;
import edu.springweb.exception.ServiceException;

public interface UserService {

	public boolean isValidUser(User user) throws ServiceException;

	public User findActiveUser(User loggedInUser) throws ServiceException;

	public Collection<Role> findRolesForUser(User loggedInUser) throws ServiceException;
}
