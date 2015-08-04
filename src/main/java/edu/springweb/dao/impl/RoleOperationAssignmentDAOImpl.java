package edu.springweb.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.springweb.dao.RoleOperationAssignmentDAO;
import edu.springweb.entity.Operation;
import edu.springweb.entity.Role;
import edu.springweb.entity.RoleOperationAssignment;

/**
 * 
 * @author Praveen
 * 
 */
@Repository
public class RoleOperationAssignmentDAOImpl implements
		RoleOperationAssignmentDAO {

	private static Logger logger = LoggerFactory
			.getLogger(RoleOperationAssignmentDAOImpl.class);

	private static Map<Long, RoleOperationAssignment> roleOperationMap = new HashMap<Long, RoleOperationAssignment>();

	static {
		RoleOperationAssignment roleOperationAssignment = null;
		Role role = null;
		Operation operation = null;

		role = new Role();
		role.setId(1l);
		role.setName("SUPER_ADMIN");
		operation = new Operation();
		operation.setName("VIEW");
		roleOperationAssignment = new RoleOperationAssignment();
		roleOperationAssignment.setRole(role);
		roleOperationAssignment.setOperation(operation);
		roleOperationMap.put(role.getId(), roleOperationAssignment);

		role = new Role();
		role.setId(2l);
		role.setName("ROLE_ADMIN");
		operation = new Operation();
		operation.setName("VIEW");
		roleOperationAssignment = new RoleOperationAssignment();
		roleOperationAssignment.setRole(role);
		roleOperationAssignment.setOperation(operation);
		roleOperationMap.put(role.getId(), roleOperationAssignment);

		role = new Role();
		role.setId(3l);
		role.setName("REPORT_ADMIN");
		operation = new Operation();
		operation.setName("VIEW");
		roleOperationAssignment = new RoleOperationAssignment();
		roleOperationAssignment.setRole(role);
		roleOperationAssignment.setOperation(operation);
		//roleOperationMap.put(role.getId(), roleOperationAssignment);
	}


	//@PersistenceContext
	private EntityManager entityManager;
	
	public Collection<RoleOperationAssignment> findRoleAndOperations(
			RoleOperationAssignment roleOperation) {

		logger.debug("Entered findRoleAndOperations()");

		
		return roleOperationMap.values();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
