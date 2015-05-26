package edu.springweb.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import edu.springweb.entity.Role;
import edu.springweb.entity.User;
import edu.springweb.exception.ServiceException;
import edu.springweb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public boolean isValidUser(User user) {
		
		if(null==user)
			return false;
		else 
			return true;
	}

	public User findActiveUser(User loggedInUser) throws ServiceException {

		loggedInUser.setFirstName("Praveen Kumar");
		loggedInUser.setLastName("Mishra");
		loggedInUser.setId(1L);
		return loggedInUser;
	}

	public Collection<Role> findRolesForUser(User loggedInUser) throws ServiceException {
		// TODO Auto-generated method stub
		Collection<Role> roleList = new ArrayList<Role>();
		Role userRole = new Role();
		userRole.setId(1L);
		userRole.setName("USER");
		roleList.add(userRole);
		return roleList;
	}

}
