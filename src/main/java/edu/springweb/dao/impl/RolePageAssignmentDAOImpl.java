/**
 * 
 */
package edu.springweb.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.springweb.dao.RolePageAssignmentDAO;
import edu.springweb.entity.Role;
import edu.springweb.entity.RolePageAssignment;


/**
 * @author Praveen
 * 
 */
public class RolePageAssignmentDAOImpl implements RolePageAssignmentDAO {

	@PersistenceContext
	private EntityManager myEntityManager;

	private static Logger logger = LoggerFactory.getLogger(RolePageAssignmentDAOImpl.class);

	public Role findPageAssignments(RolePageAssignment rolePageAssignment) {

		logger.debug("Entered findPageAssignments()");
		return null;

	}

	public EntityManager getEntityManager() {
		return myEntityManager;
	}

}
