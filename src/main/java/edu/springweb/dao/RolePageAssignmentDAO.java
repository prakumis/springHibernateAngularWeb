/**
 * 
 */
package edu.springweb.dao;

import edu.springweb.entity.Role;
import edu.springweb.entity.RolePageAssignment;

/**
 * @author Praveen
 * 
 */
public interface RolePageAssignmentDAO {

	/**Retrieves pages for the input role
	 * @param rolePageAssignment
	 * @return
	 */
	public Role findPageAssignments(RolePageAssignment rolePageAssignment);

}
