package edu.springweb.dao;

import java.util.Collection;

import edu.springweb.entity.RoleOperationAssignment;


/**
 * 
 * @author Praveen
 * 
 */
public interface RoleOperationAssignmentDAO {

	/**
	 * Retrieves {@code Role} and its corresponding {@code Operation}s for the
	 * provided role id. If no mapping is available for the role, the role info
	 * alone is returned.
	 * 
	 * @param roleOperation
	 * @return
	 */
	Collection<RoleOperationAssignment> findRoleAndOperations(
			RoleOperationAssignment roleOperation);

}
