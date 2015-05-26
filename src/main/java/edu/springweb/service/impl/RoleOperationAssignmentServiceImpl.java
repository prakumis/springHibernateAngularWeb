package edu.springweb.service.impl;

import java.util.Collection;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.springweb.dao.RoleOperationAssignmentDAO;
import edu.springweb.dao.RolePageAssignmentDAO;
import edu.springweb.entity.RoleOperationAssignment;
import edu.springweb.exception.ServiceException;
import edu.springweb.service.RoleOperationAssignmentService;


/**
 * 
 * @author Praveen
 * 
 */
@Service(value="roleOperationAssignmentService")
public class RoleOperationAssignmentServiceImpl implements
		RoleOperationAssignmentService {

	private static Logger logger = LoggerFactory
			.getLogger(RoleOperationAssignmentServiceImpl.class);

	private RolePageAssignmentDAO rolePageAssignmentDAO;

	@Inject
	private RoleOperationAssignmentDAO roleOperationAssignmentDAO;

	public RoleOperationAssignmentServiceImpl() {
		logger.info("RoleOperationAssignmentServiceImpl Instantiated");
	}

	public Collection<RoleOperationAssignment> findRoleAndOperations(RoleOperationAssignment roleOperation) throws ServiceException {
		logger.debug("Find Operations for Role Invoked");
		Collection<RoleOperationAssignment> roleOperations = null;
		try {
			// TODO - input validations
			roleOperations = getRoleOperationAssignmentDAO().findRoleAndOperations(roleOperation);

			if (roleOperation==null || roleOperations.isEmpty()) {
				logger.debug("No Operations for Role Id : " + roleOperation.getRole().getId());

				logger.error("***************** This should not be printed");
				/*
				Role role = getRoleOperationAssignmentDAO().findRoleById(roleOperation.getRole().getId());
				roleOperation.setRole(role);
				roleOperations.add(roleOperation);	*/
			}

		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
		return roleOperations;
	}

	public RolePageAssignmentDAO getRolePageAssignmentDAO() {
		return rolePageAssignmentDAO;
	}

	public void setRolePageAssignmentDAO(RolePageAssignmentDAO rolePageAssignmentDAO) {
		this.rolePageAssignmentDAO = rolePageAssignmentDAO;
	}

	public RoleOperationAssignmentDAO getRoleOperationAssignmentDAO() {
		return roleOperationAssignmentDAO;
	}

	public void setRoleOperationAssignmentDAO(RoleOperationAssignmentDAO roleOperationAssignmentDAO) {
		this.roleOperationAssignmentDAO = roleOperationAssignmentDAO;
	}

}
