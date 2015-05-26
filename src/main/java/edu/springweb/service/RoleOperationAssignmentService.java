package edu.springweb.service;

import java.util.Collection;

import edu.springweb.entity.RoleOperationAssignment;
import edu.springweb.exception.ServiceException;


/**
 * 
 * @author Praveen
 * 
 */
public interface RoleOperationAssignmentService {

	/**
	 * Retrieves {@code Role} and its corresponding {@code Operation} for input
	 * role id. In case if there are no operations assigned for a role, returns
	 * only the Role info.
	 * 
	 * @param roleOperation
	 * @return
	 * @throws ServiceException 
	 */
	Collection<RoleOperationAssignment> findRoleAndOperations(RoleOperationAssignment roleOperation) throws ServiceException;

}
